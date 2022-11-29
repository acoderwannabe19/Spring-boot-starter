package com.example.demo.practice;

public class Rate {
    enum Star {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE
    }
    private Star value;
    private String comment;

    @Override
    public String toString() {
        return "Rate{" +
                "value=" + value +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Star getValue() {
        return value;
    }

    public void setValue(Star value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Rate() {
    }
}
