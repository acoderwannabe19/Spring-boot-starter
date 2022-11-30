package com.example.demo.classes;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
public class GroupCHO {

    @ElementCollection
    private List<Long> chos;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDate creation_date;


    @OneToMany
    private List<Rate> rates;

}
