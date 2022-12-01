package com.example.demo.services;

import com.example.demo.classes.Info;
import com.example.demo.repositories.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {
    private final InfoRepository infoRepository;

    @Autowired
    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public List<Info> getInfos() {return infoRepository.findAll();}

    public void addInfo(Info info) {
        if(info.getRoomie().isCHO()) {
            infoRepository.save(info);
        }
        else {
            throw new IllegalStateException("User with id " + info.getRoomie().getId() + " is not a CHO.");
        }
    }
}
