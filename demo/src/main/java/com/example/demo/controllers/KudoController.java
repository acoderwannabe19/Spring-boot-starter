package com.example.demo.controllers;

import com.example.demo.classes.Kudo;
import com.example.demo.services.KudoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class KudoController {
    private final KudoService kudoService;


    public KudoController(KudoService kudoService) {
        this.kudoService = kudoService;
    }

    @GetMapping
    public List<Kudo> getKudos() {return kudoService.getKudos();}
}
