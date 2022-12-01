package com.example.demo.services;

import com.example.demo.classes.Mood;
import com.example.demo.classes.Roomie;
import com.example.demo.dto.RoomieDTO;
import com.example.demo.repositories.RoomieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private RoomieDTO convertDataIntoDTO(Roomie roomie) {
        // create instance of our UserLocationDTO class
        RoomieDTO dto = new RoomieDTO();

        //set username and userId in dto from the userData
        dto.setFull_name(roomie.getFull_name());
        dto.setService(roomie.getService());
        dto.setCHO(roomie.isCHO());
        return dto;
    }

    public void addNewRoomie(Roomie roomie) {
        Optional<Roomie> roomieByUsername = roomieRepository.findRoomieByUsername(roomie.getUsername());
        if(roomieByUsername.isPresent()) {
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

    public List<Roomie> getRoomie(String username) {
        List<Roomie> roomies = new ArrayList<>();
        for (Roomie roomie: roomieRepository.findAll()
        ) {
            if (roomie.getUsername().equals(username)) {
                roomies.add(roomie);
            }
        }
        return roomies;
    }
}
