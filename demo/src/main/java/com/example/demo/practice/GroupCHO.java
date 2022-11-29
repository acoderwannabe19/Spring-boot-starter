package com.example.demo.practice;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class GroupCHO {
    List<CHO> chos;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDate creation_date;

    @OneToMany
    private List<Roomie> raters;

}
