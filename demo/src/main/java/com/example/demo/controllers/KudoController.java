package com.example.demo.controllers;

import com.example.demo.classes.Kudo;
import com.example.demo.services.KudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/kudo")
public class KudoController {
    private final KudoService kudoService;

    @Autowired
    public KudoController(KudoService kudoService) {
        this.kudoService = kudoService;
    }

    @GetMapping
    public List<Kudo> getKudos() {return kudoService.getKudos();}

    @GetMapping(path = "{username}")
    public List<Kudo> getReceivedKudos(@PathVariable("username") String username) {return kudoService.getReceivedKudos(username);}

}
