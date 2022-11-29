package com.example.demo.practice;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

public class Kudo {
    @Id
    @SequenceGenerator(
            name = "kudo_sequence",
            sequenceName = "kudo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "kudo_sequence"
    )
    private Long id_kudo;
    private String appreciation;
    private String message;

    @Override
    public String toString() {
        return "Kudo{" +
                "id_kudo=" + id_kudo +
                ", appreciation='" + appreciation + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", id_giver=" + id_giver +
                ", id_recipient=" + id_recipient +
                '}';
    }

    public void setId_kudo(Long id_kudo) {
        this.id_kudo = id_kudo;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId_giver(Long id_giver) {
        this.id_giver = id_giver;
    }

    public void setId_recipient(Long id_recipient) {
        this.id_recipient = id_recipient;
    }

    public Long getId_kudo() {
        return id_kudo;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getId_giver() {
        return id_giver;
    }

    public Long getId_recipient() {
        return id_recipient;
    }

    private LocalDate date;
    private Long id_giver;
    private Long id_recipient;

    public Kudo() {
    }

    public Kudo(Long id_kudo, String appreciation, String message, LocalDate date, Long id_giver, Long id_recipient) {
        this.id_kudo = id_kudo;
        this.appreciation = appreciation;
        this.message = message;
        this.date = date;
        this.id_giver = id_giver;
        this.id_recipient = id_recipient;
    }
}
