package com.example.demo.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
public class Mood {
    public Mood() {
    }

    public Mood(Mood_value value, LocalDate date, Roomie roomie) {
        this.value = value;
        this.date = date;
        this.roomie = roomie;
    }

    public enum Mood_value {
        HAPPY,
        NEUTRAL,
        ANGRY,
    }

    @Id
    @GeneratedValue
    private Long id;


    @Column
    private Mood_value value;

    @Column
    private LocalDate date;

    @ManyToOne
    private Roomie roomie;
}
