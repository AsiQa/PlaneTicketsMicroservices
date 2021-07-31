package com.raf.karte.service.dto;

import java.math.BigDecimal;

public class KartaCreateDto {

    private Long userId;
    private Long letId;
    private BigDecimal cena;


    public KartaCreateDto(Long userId, Long letId, BigDecimal cena) {
        this.userId = userId;
        this.letId = letId;
        this.cena = cena;
    }

    public KartaCreateDto(){

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLetId() {
        return letId;
    }

    public void setLetId(Long letId) {
        this.letId = letId;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }
}
