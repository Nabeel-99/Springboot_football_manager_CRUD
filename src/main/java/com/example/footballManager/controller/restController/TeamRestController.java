package com.example.footballManager.controller.restController;

import com.example.footballManager.model.Team;
import com.example.footballManager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamRestController {
    private final TeamService teamService;

    @Autowired
    public TeamRestController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAllTeams(){
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Long id){
        Team team  = teamService.getTeamById(id);
        if(team != null){
            return ResponseEntity.ok(team);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Team> createTeam(@RequestBody Team team){
        Team createdTeam = teamService.saveTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable("id") Long id, @RequestBody Team team){
        Team existingTeam = teamService.getTeamById(id);
        if(existingTeam != null){
            team.setId(id);
            Team updatedTeam = teamService.saveTeam(team);
            return ResponseEntity.ok(updatedTeam);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable("id") Long id){
        Team existingTeam = teamService.getTeamById(id);
        if(existingTeam != null){
            teamService.deleteTeamById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
