package com.example.demo.classes;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Mood {
    enum Mood_value {
        HAPPY,
        NEUTRAL,
        ANGRY,
    }

    @Id
    @SequenceGenerator(
            name = "mood_sequence",
            sequenceName = "mood_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mood_sequence"
    )


    @Column
    private Mood_value value;

    @Column
    private LocalDate date;

    @ManyToOne
    private Roomie roomie;
}
