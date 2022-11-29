package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository) {
        return args -> {
            Student moussa = new Student(
                    "Moussa NIANG",
                    LocalDate.of(2001, Month.MAY, 26),
                    "niamgm@ept.sn"
            );

            Student fatou = new Student(
                    "Fatou SALL",
                    LocalDate.of(2001, Month.JUNE, 1),
                    "sfatou@ept.sn"
            );

            repository.saveAll(
                    List.of(moussa, fatou)
            );


        };
    }
}
