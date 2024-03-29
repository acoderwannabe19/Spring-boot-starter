package com.example.demo.student;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table

public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    @Transient
    private Integer age;
    private String email;

    public Student() {
    }


    public Student(
            String name,
            LocalDate dateOfBirth,
            String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
