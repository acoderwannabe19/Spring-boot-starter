package com.example.demo.practice;

import javax.persistence.Column;

public class Rate {
    enum Star {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE
    }

    @Column
    private Star value;

    @Column
    private String comment;


}
