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
public class Kudo {
    public Kudo() {
    }

    public enum Level{
        MERCI_BEAUCOUP,
        BIEN_JOUE,
        FELICITATIONS,
        EXTRAORDINAIRE,
        EXCELLENT_TRAVAIL,

    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    Roomie giver;

    @ManyToOne
    Roomie recipient;

    @Column(nullable = false)
    private Level appreciation;

    @Column
    private String message;

    @Column
    private LocalDate date;

    public Kudo(Roomie giver, Roomie recipient, Level appreciation, String message, LocalDate date) {

        this.giver = giver;
        this.recipient = recipient;
        this.appreciation = appreciation;
        this.message = message;
        this.date = date;
    }
}

