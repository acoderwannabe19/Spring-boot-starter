package com.example.demo.classes;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Rate {
    enum Star {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE
    }

    @Id
    private Long id;

    @Column
    private Star value;

    @Column
    private String comment;

    @ManyToOne
    GroupCHO groupCHO;


}
