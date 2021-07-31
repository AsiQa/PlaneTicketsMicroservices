package com.raf.flight.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvionDto {

    private Long id;
    private String naziv;
    private Integer kapacitet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }
}
