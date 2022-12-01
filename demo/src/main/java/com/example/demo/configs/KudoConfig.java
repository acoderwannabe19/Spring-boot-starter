package com.example.demo.configs;

import com.example.demo.classes.Kudo;
import com.example.demo.repositories.KudoRepository;
import com.example.demo.repositories.RoomieRepository;
import com.example.demo.services.RoomieService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;


public class KudoConfig {
    @Bean
    CommandLineRunner commandLineRunner (KudoRepository kudoRepository, RoomieRepository roomieRepository) {
        return args -> {
            Kudo to_fatou = new Kudo(
                    roomieRepository.findRoomieByUsername("bouyakande").get(),
                    roomieRepository.findRoomieByUsername("fatousall").get(),
                    Kudo.Level.EXTRAORDINAIRE,
                    "Way to go Fatou!",
                    LocalDate.of(2022, Month.NOVEMBER, 30)
            );
            kudoRepository.save(to_fatou);
        };
    }
}
