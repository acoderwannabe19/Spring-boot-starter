package com.example.demo.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@AllArgsConstructor
public class Info {
    public Info() {
    }

    public Info(String content, LocalDate date, Roomie roomie) {
        this.content = content;
        this.date = date;
        this.roomie = roomie;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String content;

    @Column
    private LocalDate date;

    @ManyToOne
    private Roomie roomie;


}
