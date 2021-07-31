package com.raf.flight.service.service;

import com.raf.flight.service.client.userservice.dto.KartaDto;
import com.raf.flight.service.domain.Avion;
import com.raf.flight.service.domain.Let;
import com.raf.flight.service.dto.AvionCreateDto;
import com.raf.flight.service.dto.AvionDto;
import com.raf.flight.service.dto.LetCreateDto;
import com.raf.flight.service.dto.LetDto;
import com.raf.flight.service.exception.NotFoundException;
import com.raf.flight.service.mapper.LetMapper;
import com.raf.flight.service.repository.AvionRepository;
import com.raf.flight.service.repository.LetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class LetService {

    private LetRepository letRepository;
    private LetMapper letMapper;
    private AvionRepository avionRepository;
    private RestTemplate kartaServiceRestTemplate;

    private List<String> letOtkazanEmail;

    public LetService(LetRepository letRepository, LetMapper letMapper, AvionRepository avionRepository) {
        this.letRepository = letRepository;
        this.letMapper = letMapper;
        this.avionRepository = avionRepository;
    }


    public Page<LetDto> findAllLetove(Pageable pageable) {

        //filtriraj ako kapacitet nije pun//dodati
        
        return letRepository.findAll(pageable)
                .map(letMapper::letToLetDto);
    }

    public LetDto addLet(LetCreateDto letCreateDto){
        Let let = letMapper.letCreateDtoToLet((letCreateDto));
        letRepository.save(let);
        return letMapper.letToLetDto(let);
    }

    public String removeLet(Long id){

        //proveri dal je prodata karta


        ResponseEntity<KartaDto> kartaDtoResponseEntity = null;
        Integer kolkoMilja = 0;


        try {
            kartaDtoResponseEntity = kartaServiceRestTemplate.exchange("/karta/"
                    + id, HttpMethod.GET, null, KartaDto.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND))
                throw new NotFoundException(String.format("Karta id: %d nije pronadjena.", id));
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(kartaDtoResponseEntity != null){
            return "Karta je vec prodata za ovaj let";
        }else{

            //brise let
            letRepository.deleteById(id);

            return "Let je uspesno obrisan";
        }
    }

    public Page<LetDto> findAllSearch(Long id, Long avionId, String pocetna, String krajnja, Long duzinaLeta, BigDecimal cena, Pageable pageable) {

        if(avionId != null)
            return letRepository.findByAvionId(avionId, pageable).map(letMapper::letToLetDto);
        else if(pocetna != null)
            return letRepository.findAllByPocetna(pocetna, pageable).map(letMapper::letToLetDto);
        else if(krajnja != null)
            return letRepository.findAllByKrajnja(krajnja, pageable).map(letMapper::letToLetDto);
        else if(duzinaLeta != null)
            return letRepository.findAllByDuzinaLeta(duzinaLeta, pageable).map(letMapper::letToLetDto);
        else if(cena != null)
            return letRepository.findAllByCena(cena, pageable).map(letMapper::letToLetDto);
        else
            return letRepository.findAll(pageable).map(letMapper::letToLetDto);
    }

}
