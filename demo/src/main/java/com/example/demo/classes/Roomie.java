package com.example.demo.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
public class Roomie {
    public Roomie() {
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false)
    private String username;

    @Column
    private String service;

    @Column
    private LocalDate lastMandate;

    @Column
    private boolean isCHO;


    public Roomie(String full_name, String username, String service, LocalDate lastMandate, boolean isCHO) {
        this.full_name = full_name;
        this.username = username;
        this.service = service;
        this.lastMandate = lastMandate;
        this.isCHO = isCHO;
    }
}