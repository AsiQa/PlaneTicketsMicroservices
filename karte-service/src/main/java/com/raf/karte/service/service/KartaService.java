package com.raf.karte.service.service;

import com.raf.karte.service.client.flightservice.dto.LetDto;
import com.raf.karte.service.client.userservice.dto.DiscountDto;
import com.raf.karte.service.domain.Karta;
import com.raf.karte.service.dto.KartaCreateDto;
import com.raf.karte.service.dto.KartaDto;
import com.raf.karte.service.exception.NotFoundException;
import com.raf.karte.service.mapper.KartaMapper;
import com.raf.karte.service.repository.KartaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class KartaService {

    private KartaRepository kartaRepository;
    private KartaMapper kartaMapper;
    private RestTemplate letServiceRestTemplate;
    private RestTemplate userServiceRestTemplate;
    private String s = "PROSLO";


    public KartaService(KartaRepository kartaRepository, RestTemplate letServiceRestTemplate, RestTemplate userServiceRestTemplate) {
        this.kartaRepository = kartaRepository;
        this.letServiceRestTemplate = letServiceRestTemplate;
        this.userServiceRestTemplate = userServiceRestTemplate;
    }

    public void addKarta(KartaCreateDto kartaCreateDto){

        //proveri kartice korisnika



        ResponseEntity<LetDto> letDtoResponseEntity = null;
        Integer kolkoMilja = 0;


        try {
            letDtoResponseEntity = letServiceRestTemplate.exchange("/let/"
                    + kartaCreateDto.getLetId(), HttpMethod.GET, null, LetDto.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND))
                throw new NotFoundException(String.format("Let id: %d nije pronadjen.", kartaCreateDto.getLetId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //uhvati discount
        ResponseEntity<DiscountDto> discountDtoResponseEntity = userServiceRestTemplate.exchange("/user/" +
                kartaCreateDto.getUserId() + "/discount", HttpMethod.GET, null, DiscountDto.class);
        //izracunaj cenu
        BigDecimal cena = letDtoResponseEntity.getBody().getCena().divide(BigDecimal.valueOf(100))
                .multiply(BigDecimal.valueOf(100 - discountDtoResponseEntity.getBody().getDiscount()));


        //update milje korisniku

//        kolkoMilja =  letServiceRestTemplate.exchange("/let/getMilje"
//                , HttpMethod.GET, null, LetDto.class);

        //ne znamo sta da posaljemo kad trazi kolko Milja da doda a vraca null
//        userServiceRestTemplate.exchange("/user/" +
//                kartaCreateDto.getUserId() + "/addMilje", HttpMethod.PUT, null, );

        //sacuvaj rezervaciju
        Karta karta = new Karta(kartaCreateDto.getUserId(), kartaCreateDto.getLetId(), cena);
        kartaRepository.save(karta);

    }

    public KartaDto getKarte(Long id){

        Karta karta = kartaRepository
                .findByUserId(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Karta with id: %d not found.", id)));
        
       return kartaMapper.kartaToKartaDto(karta);
    }



    public KartaDto ifKartaExists(Long id){
        Karta karta = kartaRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Karta with id: %d not found.", id)));

        return kartaMapper.kartaToKartaDto(karta);
    }

}
