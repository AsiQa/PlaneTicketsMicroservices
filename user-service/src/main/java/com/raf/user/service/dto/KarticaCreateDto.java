package com.raf.user.service.dto;

import javax.validation.constraints.NotBlank;

public class KarticaCreateDto {


    @NotBlank
    private String ime;
    @NotBlank
    private String prezime;
    @NotBlank
    private Integer brojKartice;
    @NotBlank
    private Integer cvv;

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

}
