package com.raf.user.service.mapper;

import com.raf.user.service.domain.Kartica;
import com.raf.user.service.domain.User;
import com.raf.user.service.dto.UserCreateDto;
import com.raf.user.service.dto.UserDto;
import com.raf.user.service.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private RoleRepository roleRepository;

    public UserMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }


    public User userCreateDtoToUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setPassword(userCreateDto.getPassword());
        user.setRole(roleRepository.findRoleByName("ROLE_USER").get());
        user.setMilje(0);
        return user;
    }
}
