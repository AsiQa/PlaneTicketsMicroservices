package com.raf.karte.service.controller;

import com.raf.karte.service.dto.KartaCreateDto;
import com.raf.karte.service.dto.KartaDto;
import com.raf.karte.service.service.KartaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/karta")
public class KartaController {

    private KartaService kartaService;

    public KartaController(KartaService kartaService) {
        this.kartaService = kartaService;
    }


    @PostMapping
    public ResponseEntity<Void> addKarta(@RequestBody @Valid KartaCreateDto kartaCreateDto) {
        kartaService.addKarta(kartaCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/{id}/getKarte")
    public ResponseEntity<KartaDto> getKarte(@PathVariable("id") Long id) {
        return new ResponseEntity<>(kartaService.getKarte(id), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<KartaDto> ifKartaExists(@PathVariable("id") Long id) {
        return new ResponseEntity<>(kartaService.ifKartaExists(id), HttpStatus.OK);
    }


}
