package com.example.demo.controllers;

import com.example.demo.classes.Roomie;
import com.example.demo.dto.RoomieDTO;
import com.example.demo.services.RoomieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "{username}")
    public List<Roomie> getRoomie(@PathVariable("username") String username){return roomieService.getRoomie(username);}

    @PostMapping(path = "/inscription")
    public void addNewRoomie(@RequestBody Roomie roomie) { roomieService.addNewRoomie(roomie); }

    @DeleteMapping(path = "{roomieId}")
    public void deleteRoomie(@PathVariable("roomieId") Long roomieId) {roomieService.deleteRoomie(roomieId);}
}
