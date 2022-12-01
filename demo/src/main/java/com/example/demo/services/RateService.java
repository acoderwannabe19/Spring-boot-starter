package com.example.demo.services;

import com.example.demo.classes.Rate;
import com.example.demo.repositories.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {
    public final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public List<Rate> getRates() {
        return rateRepository.findAll();
    }
}
