package com.example.demo.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.temporal.WeekFields;

@Entity
public class Info {
    @Id
    private Long id;

    @Column
    private String content;

    @Column
    private LocalDate date;


}
