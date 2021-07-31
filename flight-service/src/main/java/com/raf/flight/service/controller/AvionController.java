package com.raf.flight.service.controller;

import com.raf.flight.service.dto.AvionCreateDto;
import com.raf.flight.service.dto.AvionDto;
import com.raf.flight.service.secutiry.CheckSecurity;
import com.raf.flight.service.service.AvionService;
import com.raf.flight.service.service.LetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/avion")
public class AvionController {

    private AvionService avionService;


    @PostMapping("addAvion")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<AvionDto> addAvion(@RequestHeader("Authorization") String authorization,
                                             @RequestBody @Validated AvionCreateDto avionCreateDto) {
        return new ResponseEntity<>(avionService.addAvion(avionCreateDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}/removeAvion")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<String> removeAvion(@RequestHeader("Authorization") String authorization,
                                            @PathVariable("id") Long id) {
        return new ResponseEntity<>(avionService.removeAvion(id), HttpStatus.OK);
    }


}
