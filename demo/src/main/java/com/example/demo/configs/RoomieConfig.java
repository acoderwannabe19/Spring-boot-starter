package com.example.demo.configs;

import com.example.demo.classes.Info;
import com.example.demo.classes.Kudo;
import com.example.demo.classes.Mood;
import com.example.demo.classes.Roomie;
import com.example.demo.repositories.InfoRepository;
import com.example.demo.repositories.KudoRepository;
import com.example.demo.repositories.MoodRepository;
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
    CommandLineRunner commandLineRunner3 (RoomieRepository roomieRepository, KudoRepository kudoRepository, MoodRepository moodRepository, InfoRepository infoRepository) {
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
            Roomie ndeye_fatou = new Roomie(
                    "Ndeye Fatou SALL",
                    "ndeyefatousall",
                    "SNT DSI/DAC/DIF/DS",
                    LocalDate.of(2022, Month.NOVEMBER, 15),
                    false
            );
            Roomie seni = new Roomie(
                    "Seni NIASS",
                    "seniniass",
                    "SNT DSI/DAC/DIF/DS",
                    LocalDate.of(2022, Month.OCTOBER, 7),
                    true
            );
            roomieRepository.saveAll(List.of(bouya, fatou, seni, ndeye_fatou));

            Kudo to_fatou = new Kudo(
                    roomieRepository.findRoomieByUsername("bouyakande").orElse(null),
                    roomieRepository.findRoomieByUsername("fatousall").orElse(null),
                    Kudo.Level.EXTRAORDINAIRE,
                    "Way to go Fatou!",
                    LocalDate.of(2022, Month.NOVEMBER, 30)
            );
            Kudo to_ndeye_fatou = new Kudo(
                    roomieRepository.findRoomieByUsername("seniniass").orElse(null),
                    roomieRepository.findRoomieByUsername("ndeyefatousall").orElse(null),
                    Kudo.Level.EXCELLENT_TRAVAIL,
                    "Way to go Fatou!",
                    LocalDate.of(2022, Month.NOVEMBER, 26)
            );
            kudoRepository.saveAll(List.of(to_fatou, to_ndeye_fatou));

            Mood bouya_mood1 = new Mood(
                    Mood.Mood_value.HAPPY,
                    LocalDate.of(2022, Month.DECEMBER, 1),
                    roomieRepository.findRoomieByUsername("bouyakande").orElse(null)
            );
            Mood bouya_mood2 = new Mood(
                    Mood.Mood_value.NEUTRAL,
                    LocalDate.of(2022, Month.DECEMBER, 2),
                    roomieRepository.findRoomieByUsername("bouyakande").orElse(null)
            );
            Mood seni_mood = new Mood(
                    Mood.Mood_value.ANGRY,
                    LocalDate.of(2022, Month.DECEMBER, 2),
                    roomieRepository.findRoomieByUsername("seniniass").orElse(null)
            );
            moodRepository.saveAll(List.of(bouya_mood1, bouya_mood2, seni_mood));

            Info seni_info = new Info(
                    "Pause Ataya ak Thiaf les gars, buleenko keenn neettali!",
                    LocalDate.of(2022, Month.NOVEMBER, 3),
                    roomieRepository.findRoomieByUsername("seniniass").orElse(null)
            );
            infoRepository.save(seni_info);







        };
    }
}
