package com.raf.user.service.dto;

import javax.validation.constraints.NotBlank;

public class KarticaDto {

    private Long id;
    private String ime;
    private String prezime;
    private Integer brojKartice;
    private Integer cvv;
    private Long userId;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getBrojKartice() {
        return brojKartice;
    }

    public void setBrojKartice(Integer brojKartice) {
        this.brojKartice = brojKartice;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
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
}
