package com.raf.user.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer minMilja;
    private Integer maxMilja;
    private Integer discount;


    public UserStatus(Integer minMilja, Integer maxMilja, Integer discount) {
        this.minMilja = minMilja;
        this.maxMilja = maxMilja;
        this.discount = discount;
    }

    public UserStatus(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMinMilja() {
        return minMilja;
    }

    public void setMinMilja(Integer minMilja) {
        this.minMilja = minMilja;
    }

    public Integer getMaxMilja() {
        return maxMilja;
    }

    public void setMaxMilja(Integer maxMilja) {
        this.maxMilja = maxMilja;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
