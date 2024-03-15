package com.example.demo.controllers;

import com.example.demo.classes.Roomie;
import com.example.demo.dto.RoomieDTO;
import com.example.demo.services.RoomieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/roomie")
public class RoomieController {

    private final RoomieService roomieService;

    @Autowired
    public RoomieController(RoomieService roomieService, ModelMapper modelMapper) {
        this.roomieService = roomieService;
        this.modelMapper = modelMapper;
    }
    private final ModelMapper modelMapper;


    private RoomieDTO convertToDto(Roomie roomie) {
        RoomieDTO roomieDTO = modelMapper.map(roomie, RoomieDTO.class);
        return roomieDTO;
    }

    @GetMapping
    @ResponseBody
    public List<RoomieDTO> getRoomies() {
        List<Roomie> roomies = roomieService.getRoomies();
        return roomies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{username}")
    public RoomieDTO getRoomie(@PathVariable("username") String username){
        return convertToDto(roomieService.getRoomie(username));}

    @PostMapping(path = "/inscription")
    public void addNewRoomie(@RequestBody Roomie roomie) { roomieService.addNewRoomie(roomie); }

    @PutMapping(path = "username")
    public void updateRoomie(@PathVariable("username") String username,
                             @RequestParam(required = false) boolean isCHO) {
        roomieService.updateRoomie(username, isCHO);
    }

    @DeleteMapping(path = "{roomieId}")
    public void deleteRoomie(@PathVariable("roomieId") Long roomieId) {roomieService.deleteRoomie(roomieId);}
}
