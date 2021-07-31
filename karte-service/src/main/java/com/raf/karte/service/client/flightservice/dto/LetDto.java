package com.raf.karte.service.client.flightservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class LetDto {

    private Long id;
    @JsonProperty("avion")
    private AvionDto avionDto;
    private String pocetna;
    private String krajnja;
    private Long duzinaLeta;
    private BigDecimal cena;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AvionDto getAvionDto() {
        return avionDto;
    }

    public void setAvionDto(AvionDto avionDto) {
        this.avionDto = avionDto;
    }

    public String getPocetna() {
        return pocetna;
    }

    public void setPocetna(String pocetna) {
        this.pocetna = pocetna;
    }

    public String getKrajnja() {
        return krajnja;
    }

    public void setKrajnja(String krajnja) {
        this.krajnja = krajnja;
    }

    public Long getDuzinaLeta() {
        return duzinaLeta;
    }

    public void setDuzinaLeta(Long duzinaLeta) {
        this.duzinaLeta = duzinaLeta;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }
}
