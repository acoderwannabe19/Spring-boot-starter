package com.example.demo.configs;

import com.example.demo.classes.Roomie;
import com.example.demo.repositories.RoomieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class RoomieConfig {

    @Bean
    CommandLineRunner commandLineRunner(RoomieRepository roomieRepository) {
        return args -> {
            Roomie bouya = new Roomie(
                    "Bouya Kande",
                    "bouyakande",
                    "SNT DAC/DIF/DS",
                    LocalDate.of(2022, Month.OCTOBER, 23),
                    false
            );
            roomieRepository.save(bouya);
        };
    }
}
