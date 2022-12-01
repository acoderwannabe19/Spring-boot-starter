package com.example.demo.services;

import com.example.demo.classes.Kudo;
import com.example.demo.repositories.KudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Kudo> getReceivedKudos(String username) {
        List<Kudo> kudos = new ArrayList<>();
        for (Kudo kudo: kudoRepository.findAll()
             ) {
            if (kudo.getRecipient().getUsername().equals(username)) {
                kudos.add(kudo);
            }
        }
        return kudos;
    }


}
