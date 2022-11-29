package com.example.demo.practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roomie implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false)
    private String username;

    @Column
    private String service;

    @Column
    private String lastMandate;

    @Column
    private boolean isCHO;

    @ManyToMany
    List<Roomie> giver;

    @ManyToMany
    List<Roomie> recipient;


}