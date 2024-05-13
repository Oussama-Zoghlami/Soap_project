package com.springbootsoap.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "etudiant")
public class Etudiant implements Serializable {
    private static final long serialVersion =1l;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "etudiantid")
    private Long etudiantId;
    @Column (name="name")
    private String name;
    @Column (name="phone")
    private String phone;
    @Column (name="address")
    private String address;

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}

