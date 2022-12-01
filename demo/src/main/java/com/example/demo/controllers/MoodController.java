package com.example.demo.controllers;

import com.example.demo.classes.Mood;
import com.example.demo.services.MoodService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/mood")
public class MoodController {
    private final MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @GetMapping
    public List<Mood> getMoods() {return moodService.getMoods();}

    @GetMapping(path = "{username}")
    public List<Mood> getMoodsOf(@PathVariable("username") String username){return moodService.getMoodsOf(username);}
}
