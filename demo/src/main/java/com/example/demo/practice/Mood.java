package com.example.demo.practice;

import java.time.LocalDate;

public class Mood {
    enum Mood_value {
        HAPPY,
        NEUTRAL,
        ANGRY,
    }
    private Mood_value value;
    private LocalDate date;
    private Long id_roomie;
}
