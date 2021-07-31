package com.raf.user.service.service;

import com.raf.user.service.domain.Kartica;
import com.raf.user.service.domain.User;
import com.raf.user.service.domain.UserStatus;
import com.raf.user.service.dto.*;
import com.raf.user.service.exception.NotFoundException;
import com.raf.user.service.mapper.KarticaMapper;
import com.raf.user.service.mapper.UserMapper;
import com.raf.user.service.repository.KarticaRepository;
import com.raf.user.service.repository.UserRepository;
import com.raf.user.service.repository.UserStatusRepository;
import com.raf.user.service.secutiry.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private TokenService tokenService;
    private UserRepository userRepository;
    private UserStatusRepository userStatusRepository;
    private KarticaRepository karticaRepository;
    private UserMapper userMapper;
    private KarticaMapper karticaMapper;


    private List<String> emailList;


    private List<String> updatedAccountEmailList;


    public UserService(UserRepository userRepository, TokenService tokenService, UserStatusRepository userStatusRepository, KarticaRepository karticaRepository, UserMapper userMapper, KarticaMapper karticaMapper) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.userMapper = userMapper;
        this.karticaRepository = karticaRepository;
        this.userStatusRepository = userStatusRepository;
        this.karticaMapper = karticaMapper;
    }

    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::userToUserDto);
    }

    public DiscountDto findDiscount(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with id: %d not found.", id)));
        List<UserStatus> userStatusList = userStatusRepository.findAll();
        //get discount
        Integer discount = userStatusList.stream()
                .filter(userStatus -> userStatus.getMaxMilja() >= user.getMilje()
                        && userStatus.getMinMilja() <= user.getMilje())
                .findAny()
                .get()
                .getDiscount();
        return new DiscountDto(discount);
    }

    public UserDto add(UserCreateDto userCreateDto) {
        User user = userMapper.userCreateDtoToUser(userCreateDto);
        //ubacuje email u listu za slanje mailova
        emailList.add(userCreateDto.getEmail());

        //cuva usera
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        //Try to find active user for specified credentials
        User user = userRepository
                .findUserByEmailAndPassword(tokenRequestDto.getEmail(), tokenRequestDto.getPassword())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with email: %s and password: %s not found.", tokenRequestDto.getEmail(),
                                tokenRequestDto.getPassword())));
        //Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("role", user.getRole().getName());
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));
    }

    public void addKartica(Long id, KarticaCreateDto karticaCreateDto){

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with id: %d not found.", id)));

        Kartica kartica = karticaMapper.karticaCreateDtoToKartica(karticaCreateDto);
        //dodaj user ID na karticu
//        kartica.setUserId(id);


        user.getKartica().add(kartica);
        //cuva karticu i vraca
        userRepository.save(user);
        karticaRepository.save(kartica);
    }

    public void addMilje(Long id, Integer milje) {
        //Try to find active user for specified credentials
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with id: %d not found.", id)));
        //Update milje
        user.setMilje(user.getMilje()+milje);
        //Save and return
        userRepository.save(user);
    }

    public void removeMilje(Long id, Integer milje) {
        //Try to find active user for specified credentials
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with id: %d not found.", id)));
        //Update milje
        user.setMilje(user.getMilje()-milje);
        //Save and return
        userRepository.save(user);
    }

    public UserDto updateUser(Long id, UserCreateDto userCreateDto) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with id: %d not found.", id)));

        //ako promeni email posalji mail
        user.setEmail(userCreateDto.getEmail());

        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setPassword(userCreateDto.getPassword());

        //salje mail da je profil promenjen
        updatedAccountEmailList.add(user.getEmail());

        //cuva nove informacije
        userRepository.save(user);

        return userMapper.userToUserDto(user);
    }


}


