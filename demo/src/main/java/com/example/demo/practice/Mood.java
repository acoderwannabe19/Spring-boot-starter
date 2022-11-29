package com.example.demo.practice;

import javax.persistence.*;
import java.time.LocalDate;


public class Mood {
    enum Mood_value {
        HAPPY,
        NEUTRAL,
        ANGRY,
    }


    @Column
    private Mood_value value;

    @Column
    private LocalDate date;

    @ManyToOne
    private Roomie roomie;
}
