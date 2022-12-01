package com.example.demo.services;

import com.example.demo.classes.Kudo;
import com.example.demo.classes.Roomie;
import com.example.demo.repositories.KudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KudoService {
    private final KudoRepository kudoRepository;

    @Autowired
    public KudoService(KudoRepository kudoRepository) {
        this.kudoRepository = kudoRepository;
    }

    public List<Kudo> getKudos() {
        return kudoRepository.findAll();

    }

    public void giveKudo(Kudo kudo) {

        kudoRepository.save(kudo);
    }

    public List<Kudo> getReceivedKudos(String full_name) {
        List<Kudo> kudos = new ArrayList<>();
        for (Kudo kudo: kudoRepository.findAll()
             ) {
            if (kudo.getRecipient().getFull_name().equals(full_name)) {
                kudos.add(kudo);
            }

        }
        return kudos;

    }

}
