package com.example.demo.classes;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class GroupCHO {
    public GroupCHO() {
    }

    public GroupCHO(LocalDate creation_date, List<Roomie> chos) {
        this.creation_date = creation_date;
        this.chos = chos;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDate creation_date;

    @OneToMany
    private List<Roomie> chos = new ArrayList<>(3);




}

