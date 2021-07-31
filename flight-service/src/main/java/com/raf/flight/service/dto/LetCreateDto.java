package com.raf.flight.service.dto;

import java.math.BigDecimal;

public class LetCreateDto {

    private Long avionId;
    private String pocetna;
    private String krajnja;
    private Integer duzinaLeta;
    private BigDecimal cena;




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

    public Integer getDuzinaLeta() {
        return duzinaLeta;
    }

    public void setDuzinaLeta(Integer duzinaLeta) {
        this.duzinaLeta = duzinaLeta;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }


    public Long getAvionId() {
        return avionId;
    }

    public void setAvionId(Long avionId) {
        this.avionId = avionId;
    }
}
