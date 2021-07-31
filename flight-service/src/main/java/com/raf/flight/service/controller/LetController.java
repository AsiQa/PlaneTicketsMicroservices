package com.raf.flight.service.controller;

import com.raf.flight.service.domain.Avion;
import com.raf.flight.service.dto.AvionCreateDto;
import com.raf.flight.service.dto.AvionDto;
import com.raf.flight.service.dto.LetCreateDto;
import com.raf.flight.service.dto.LetDto;
import com.raf.flight.service.secutiry.CheckSecurity;
import com.raf.flight.service.service.LetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;

@RestController
@RequestMapping("/let")
public class LetController {

   private LetService letService;

    public LetController(LetService letService) {

        this.letService = letService;
    }

    @PostMapping
    public ResponseEntity<LetDto> addLet(@RequestBody @Validated LetCreateDto letCreateDto){
        addLet(letCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("addLet")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<LetDto> addLet(@RequestHeader("Authorization") String authorization,
                                             @RequestBody @Validated LetCreateDto letCreateDto) {
        return new ResponseEntity<>(letService.addLet(letCreateDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}/removeLet")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<String> removeLet(@RequestHeader("Authorization") String authorization,
                                              @PathVariable("id") Long id) {
        return new ResponseEntity<>(letService.removeLet(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<LetDto>> getAllLetove(Pageable pageable) {
        return new ResponseEntity<>(letService.findAllLetove(pageable), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<LetDto>> getAllSearch(@ApiIgnore Pageable pageable,
                                                     @RequestParam(name = "id", required = false) Long id,
                                                     @RequestParam(name = "avionId", required = false) Long avionId,
                                                     @RequestParam(name = "pocetna", required = false) String pocetna,
                                                     @RequestParam(name = "krajnja", required = false) String krajnja,
                                                     @RequestParam(name = "duzinaLeta", required = false) Long duzinaLeta,
                                                     @RequestParam(name = "cena", required = false) BigDecimal cena) {
        return new ResponseEntity<>(letService.findAllSearch(id, avionId, pocetna, krajnja, duzinaLeta, cena, pageable), HttpStatus.OK);
    }

}
