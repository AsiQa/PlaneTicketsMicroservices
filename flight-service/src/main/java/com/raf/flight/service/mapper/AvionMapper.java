package com.raf.flight.service.mapper;

import com.raf.flight.service.domain.Avion;
import com.raf.flight.service.dto.AvionCreateDto;
import com.raf.flight.service.dto.AvionDto;
import org.springframework.stereotype.Component;

@Component
public class AvionMapper {

    public AvionDto avionToAvionDto(Avion avion){
        AvionDto avionDto = new AvionDto();
        avionDto.setId(avion.getId());
        avionDto.setNaziv(avion.getNaziv());
        avionDto.setKapacitet(avion.getKapacitet());
        return avionDto;
    }

    public Avion avionCreateDtoToAvion(AvionCreateDto avionCreateDto){
        Avion avion = new Avion();
        avion.setNaziv(avionCreateDto.getNaziv());
        avion.setKapacitet(avionCreateDto.getKapacitet());
        return avion;
    }

}
