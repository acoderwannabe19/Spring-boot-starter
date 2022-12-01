package com.example.demo.configs;

import com.example.demo.classes.Kudo;
import com.example.demo.classes.Roomie;
import com.example.demo.repositories.KudoRepository;
import com.example.demo.repositories.RoomieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class RoomieConfig {

    @Bean
    CommandLineRunner commandLineRunner3 (RoomieRepository roomieRepository, KudoRepository kudoRepository) {
        return args -> {
            Roomie bouya = new Roomie(
                    "Bouya KANDE",
                    "bouyakande",
                    "SNT DSI/DAC/DIF/DS",
                    LocalDate.of(2022, Month.OCTOBER, 23),
                    false
            );

            Roomie fatou = new Roomie(
                    "Fatou SALL",
                    "fatousall",
                    "SNT DSI/DAC/DIF/DS",
                    LocalDate.of(2022, Month.NOVEMBER, 15),
                    false
            );
            roomieRepository.saveAll(List.of(bouya, fatou));

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
