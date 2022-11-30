package com.example.demo.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CHO {
    @Id
    private Long id;

    @ManyToOne
    private Roomie roomie;

}
