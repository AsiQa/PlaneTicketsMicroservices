package com.raf.flight.service.domain;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class Let {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long avionId;
    private String pocetna;
    private String krajnja;
    private Integer duzinaLeta;
    private BigDecimal cena;
    private Integer trenutniKapacitet;
    private boolean otkazan;




    public Let(){

    }

    public Let(Long avionId, String pocetna, String krajnja, Integer duzinaLeta, BigDecimal cena) {
        this.avionId = avionId;
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.duzinaLeta = duzinaLeta;
        this.cena = cena;
        this.trenutniKapacitet = 0;
        this.otkazan = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTrenutniKapacitet() {
        return trenutniKapacitet;
    }

    public void setTrenutniKapacitet(Integer trenutniKapacitet) {
        this.trenutniKapacitet = trenutniKapacitet;
    }

    public boolean isOtkazan() {
        return otkazan;
    }

    public void setOtkazan(boolean otkazan) {
        this.otkazan = otkazan;
    }

    public Long getAvionId() {
        return avionId;
    }

    public void setAvionId(Long avionId) {
        this.avionId = avionId;
    }
}
