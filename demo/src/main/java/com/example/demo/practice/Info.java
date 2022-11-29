package com.example.demo.practice;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class Info {
    @Column
    private String content;

    @ManyToOne
    private CHO poster;
}
