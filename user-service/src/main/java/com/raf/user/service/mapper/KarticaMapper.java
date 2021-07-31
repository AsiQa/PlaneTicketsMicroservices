package com.raf.user.service.mapper;

import com.raf.user.service.domain.Kartica;
import com.raf.user.service.dto.KarticaCreateDto;
import com.raf.user.service.dto.KarticaDto;
import org.springframework.stereotype.Component;

@Component
public class KarticaMapper {

    public KarticaDto karticaToKarticaDto(Kartica kartica){
        KarticaDto karticaDto = new KarticaDto();
        karticaDto.setId(kartica.getId());
        karticaDto.setIme(kartica.getIme());
        karticaDto.setPrezime(kartica.getPrezime());
        karticaDto.setBrojKartice(kartica.getBrojKartice());
        karticaDto.setCvv(kartica.getCvv());
        return karticaDto;
    }

    public Kartica karticaCreateDtoToKartica(KarticaCreateDto karticaCreateDto){
        Kartica kartica = new Kartica();
        kartica.setIme(karticaCreateDto.getIme());
        kartica.setPrezime(karticaCreateDto.getPrezime());
        kartica.setBrojKartice(karticaCreateDto.getBrojKartice());
        kartica.setCvv(karticaCreateDto.getCvv());
        return kartica;
    }
}
