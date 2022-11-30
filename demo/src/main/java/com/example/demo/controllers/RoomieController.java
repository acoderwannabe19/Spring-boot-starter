package com.example.demo.controllers;

import com.example.demo.classes.Roomie;
import com.example.demo.services.RoomieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/roomie")
public class RoomieController {

    private final RoomieService roomieService;

    @Autowired
    public RoomieController(RoomieService roomieService) {
        this.roomieService = roomieService;
    }

    @GetMapping
    public List<Roomie> getRoomies() {return  roomieService.getRoomies();}

    @PostMapping(path = "/inscription")
    public void addNewRoomie(@RequestBody Roomie roomie) { roomieService.addNewRoomie(roomie); }

    @DeleteMapping
    public void deleteRoomie(Long id) {roomieService.deleteRoomie(id);}
}
