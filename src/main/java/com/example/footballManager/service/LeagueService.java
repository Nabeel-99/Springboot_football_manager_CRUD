package com.example.footballManager.service;

import com.example.footballManager.model.League;
import com.example.footballManager.repository.LeagueRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository){
        this.leagueRepository = leagueRepository;
    }
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    public League getLeagueById(Long id) {
        return leagueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("League with ID %d not found", id)));
    }

    public void deletePlayerById(Long id) {
        leagueRepository.deleteById(id);
    }

    public League saveLeague(League league) {
        return leagueRepository.save(league);
    }
}
