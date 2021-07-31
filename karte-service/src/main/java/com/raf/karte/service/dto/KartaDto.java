package com.raf.karte.service.dto;

import java.math.BigDecimal;
import java.util.Date;

public class KartaDto {

    private Long id;
    private Long userId;
    private Long letId;
    private BigDecimal cena;
    private Date date;


    public KartaDto(){

    }

    public KartaDto(Long id, Long userId, Long letId, BigDecimal cena, Date date) {
        this.id = id;
        this.userId = userId;
        this.letId = letId;
        this.cena = cena;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
