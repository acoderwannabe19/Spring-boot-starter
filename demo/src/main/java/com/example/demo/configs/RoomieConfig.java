package com.example.demo.configs;

import com.example.demo.classes.*;
import com.example.demo.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class RoomieConfig {

    @Bean
    CommandLineRunner commandLineRunner (RoomieRepository roomieRepository, KudoRepository kudoRepository, MoodRepository moodRepository, InfoRepository infoRepository, GroupCHORepository groupCHORepository) {
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
                    roomieRepository.findRoomieByUsername("bouyakande"),
                    roomieRepository.findRoomieByUsername("fatousall"),
                    Kudo.Level.EXTRAORDINAIRE,
                    "Way to go Fatou!",
                    LocalDate.of(2022, Month.NOVEMBER, 30)
            );
            Kudo to_ndeye_fatou = new Kudo(
                    roomieRepository.findRoomieByUsername("seniniass"),
                    roomieRepository.findRoomieByUsername("ndeyefatousall"),
                    Kudo.Level.EXCELLENT_TRAVAIL,
                    "Way to go Fatou!",
                    LocalDate.of(2022, Month.NOVEMBER, 26)
            );
            kudoRepository.saveAll(List.of(to_fatou, to_ndeye_fatou));

            Mood bouya_mood1 = new Mood(
                    Mood.Mood_value.HAPPY,
                    LocalDate.of(2022, Month.DECEMBER, 1),
                    roomieRepository.findRoomieByUsername("bouyakande")
            );
            Mood bouya_mood2 = new Mood(
                    Mood.Mood_value.NEUTRAL,
                    LocalDate.of(2022, Month.DECEMBER, 2),
                    roomieRepository.findRoomieByUsername("bouyakande")
            );
            Mood seni_mood = new Mood(
                    Mood.Mood_value.ANGRY,
                    LocalDate.of(2022, Month.DECEMBER, 2),
                    roomieRepository.findRoomieByUsername("seniniass")
            );
            moodRepository.saveAll(List.of(bouya_mood1, bouya_mood2, seni_mood));

            Info seni_info = new Info(
                    "Pause Ataya ak Thiaf les gars, buleenko keenn neettali!",
                    LocalDate.of(2022, Month.NOVEMBER, 3),
                    roomieRepository.findRoomieByUsername("seniniass")
            );
            infoRepository.save(seni_info);

            GroupCHO first_group = new GroupCHO(
                    LocalDate.of(2022, Month.DECEMBER, 1),
                    List.of(roomieRepository.findRoomieByUsername("seniniass"), roomieRepository.findRoomieByUsername("bouyakande"), roomieRepository.findRoomieByUsername("fatousall"))
            );
            groupCHORepository.save(first_group);









        };
    }
}
