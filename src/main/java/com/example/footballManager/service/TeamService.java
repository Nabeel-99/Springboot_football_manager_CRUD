package com.example.footballManager.service;

import com.example.footballManager.model.Team;
import com.example.footballManager.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Team with ID %d not found", id)));
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }
}
