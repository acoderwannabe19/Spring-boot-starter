package com.example.demo.services;

import com.example.demo.classes.Roomie;
import com.example.demo.dto.RoomieDTO;
import com.example.demo.repositories.RoomieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoomieService {
    private final RoomieRepository roomieRepository;

    @Autowired
    public RoomieService(RoomieRepository roomieRepository) {
        this.roomieRepository = roomieRepository;
    }

    public List<Roomie> getRoomies() {
        return roomieRepository.findAll();

    }

    public void addNewRoomie(Roomie roomie) {
        Roomie roomieByUsername = roomieRepository.findRoomieByUsername(roomie.getUsername());
        if(roomieByUsername.getUsername() == roomie.getUsername()) {
            throw new IllegalStateException("username taken");
        }
        roomieRepository.save(roomie);
    }

    public void deleteRoomie(Long id) {
        boolean exists = roomieRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Roomie with id " + id + " does not exist.");
        }
        roomieRepository.deleteById(id);
    }

    public Roomie getRoomie(String username) {
        return roomieRepository.findRoomieByUsername(username);
    }

    @Transactional
    public void updateRoomie(String username, boolean isCHO) {
        Roomie roomie = roomieRepository.findRoomieByUsername(username);
//                .orElseThrow(() -> new IllegalStateException(
//                "Roomie with id " + username + "doesn't exist."
//        ));
        roomie.setCHO(isCHO);


    }
}
