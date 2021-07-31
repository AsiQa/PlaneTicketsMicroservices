package com.raf.flight.service.mapper;

import com.raf.flight.service.domain.Let;
import com.raf.flight.service.dto.LetCreateDto;
import com.raf.flight.service.dto.LetDto;
import com.raf.flight.service.exception.NotFoundException;
import com.raf.flight.service.repository.AvionRepository;
import org.springframework.stereotype.Component;

@Component
public class LetMapper {

    public LetDto letToLetDto(Let let){
        LetDto letDto = new LetDto();
        letDto.setId(let.getId());
        letDto.setAvionId(let.getAvionId());
        letDto.setPocetna(let.getPocetna());
        letDto.setKrajnja(let.getKrajnja());
        letDto.setDuzinaLeta(let.getDuzinaLeta());
        letDto.setCena(let.getCena());
        return letDto;
    }

    public Let letCreateDtoToLet(LetCreateDto letCreateDto){
        Let let = new Let();
        let.setAvionId(letCreateDto.getAvionId());
        let.setPocetna(letCreateDto.getPocetna());
        let.setKrajnja(letCreateDto.getKrajnja());
        let.setDuzinaLeta(letCreateDto.getDuzinaLeta());
        let.setCena(letCreateDto.getCena());
        return let;
    }


}
