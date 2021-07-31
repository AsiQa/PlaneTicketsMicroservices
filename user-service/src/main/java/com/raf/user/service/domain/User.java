package com.raf.user.service.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(indexes = {@Index(columnList = "email", unique = true)})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    @OneToMany
    private List<Kartica> kartica;
    @ManyToOne(optional = false)
    private Role role;
    private Integer milje;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getMilje() {
        return milje;
    }

    public void setMilje(Integer milje) {
        this.milje = milje;
    }

    public List<Kartica> getKartica() {
        return kartica;
    }

    public void setKartica(List<Kartica> kartica) {
        this.kartica = kartica;
    }
}
