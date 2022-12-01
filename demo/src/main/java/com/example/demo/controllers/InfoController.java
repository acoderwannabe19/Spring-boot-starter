package com.example.demo.controllers;

import com.example.demo.classes.Info;
import com.example.demo.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/info")
public class InfoController {
    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping
    public List<Info> getInfos(){return infoService.getInfos();}

    @PostMapping(path = "/add")
    public void addInfo(@RequestBody Info info) {infoService.addInfo(info);}
}
