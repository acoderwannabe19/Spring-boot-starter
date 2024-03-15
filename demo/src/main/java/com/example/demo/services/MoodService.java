package com.example.demo.services;

import com.example.demo.classes.Mood;
import com.example.demo.repositories.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoodService {
    private final MoodRepository moodRepository;

    @Autowired
    public MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    public List<Mood> getMoods() {return moodRepository.findAll();}

    public List<Mood> getMoodsOf(String username) {
        return moodRepository.getMoodsByRoomieUsername(username);
    }


}
