package com.example.footballManager.service;

import com.example.footballManager.model.Stadium;
import com.example.footballManager.repository.StadiumRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository){
        this.stadiumRepository = stadiumRepository;
    }
    public List<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }

    public Stadium getStadiumById(Long id) {
        return stadiumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Stadium with ID %d not found", id)));
    }

    public Stadium saveStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    public void deleteStadiumById(Long id) {
        stadiumRepository.deleteById(id);
    }
}
