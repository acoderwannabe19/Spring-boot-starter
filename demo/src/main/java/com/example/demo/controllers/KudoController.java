package com.example.demo.controllers;

import com.example.demo.classes.Kudo;
import com.example.demo.services.KudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
