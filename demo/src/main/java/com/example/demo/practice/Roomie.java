package com.example.demo.practice;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Roomie {
    public Long getId_roomie() {
        return id_roomie;
    }

    public void setId_roomie(Long id_roomie) {
        this.id_roomie = id_roomie;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLastMandate() {
        return lastMandate;
    }

    public void setLastMandate(String lastMandate) {
        this.lastMandate = lastMandate;
    }

    public boolean isCHO() {
        return isCHO;
    }

    public void setCHO(boolean CHO) {
        isCHO = CHO;
    }

    public Roomie() {
    }

    @Id
    @SequenceGenerator(
            name = "roomie_sequence",
            sequenceName = "roomie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "roomie_sequence"
    )
    private Long id_roomie;
    private String full_name;
    private String username;

    @Override
    public String toString() {
        return "Roomie{" +
                "id_roomie=" + id_roomie +
                ", full_name='" + full_name + '\'' +
                ", username='" + username + '\'' +
                ", service='" + service + '\'' +
                ", lastMandate='" + lastMandate + '\'' +
                ", isCHO=" + isCHO +
                '}';
    }

    private String service;
    private String lastMandate;
    private boolean isCHO;

}