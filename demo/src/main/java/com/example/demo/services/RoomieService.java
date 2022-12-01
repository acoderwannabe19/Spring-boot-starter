package com.example.demo.services;

import com.example.demo.classes.Roomie;
import com.example.demo.repositories.RoomieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
