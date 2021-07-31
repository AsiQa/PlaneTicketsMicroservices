package com.raf.flight.service.service;

import com.raf.flight.service.domain.Avion;
import com.raf.flight.service.domain.Let;
import com.raf.flight.service.dto.AvionCreateDto;
import com.raf.flight.service.dto.AvionDto;
import com.raf.flight.service.exception.NotFoundException;
import com.raf.flight.service.mapper.AvionMapper;
import com.raf.flight.service.repository.AvionRepository;
import com.raf.flight.service.repository.LetRepository;

import java.util.Optional;


public class AvionService {

    private AvionRepository avionRepository;
    private AvionMapper avionMapper;
    private LetRepository letRepository;

    public AvionService(AvionRepository avionRepository, AvionMapper avionMapper, LetRepository letRepository) {
        this.avionRepository = avionRepository;
        this.avionMapper = avionMapper;
        this.letRepository = letRepository;
    }


    public AvionDto addAvion(AvionCreateDto avionCreateDto){
        Avion avion = avionMapper.avionCreateDtoToAvion(avionCreateDto);
        avionRepository.save(avion);
        return avionMapper.avionToAvionDto(avion);
    }


    public String removeAvion(Long id){

        //PROVERA DAL JE AVION DODELJEN LETU

        if(letRepository.findByAvionId(id) != null){
            return "Avion je vec dodeljen letu";
        }else{

            //brise avion
            avionRepository.deleteById(id);
            return "Avion je uspesno obrisan";
        }
    }

}
