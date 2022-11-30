package com.example.demo.classes;

import javax.persistence.*;
import java.util.List;

@Entity
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
    Roomie rater;

    @ManyToOne
    GroupCHO groupCHO;


}
