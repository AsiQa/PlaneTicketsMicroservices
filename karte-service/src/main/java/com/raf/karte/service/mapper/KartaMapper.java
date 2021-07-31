package com.raf.karte.service.mapper;

import com.raf.karte.service.domain.Karta;
import com.raf.karte.service.dto.KartaCreateDto;
import com.raf.karte.service.dto.KartaDto;
import org.springframework.stereotype.Component;

@Component
public class KartaMapper {

    public KartaDto kartaToKartaDto(Karta karta){
        KartaDto kartaDto = new KartaDto();
        kartaDto.setId(karta.getId());
        kartaDto.setUserId(karta.getUserId());
        kartaDto.setLetId(karta.getLetId());
        kartaDto.setCena(karta.getCena());
        kartaDto.setDate(karta.getDate());
        return kartaDto;
    }

    public Karta karticaCreateDtoToKartica(KartaCreateDto kartaCreateDto){
        Karta karta = new Karta();
        karta.setUserId(kartaCreateDto.getUserId());
        karta.setLetId(kartaCreateDto.getLetId());
        karta.setCena(kartaCreateDto.getCena());
        return karta;
    }
}
