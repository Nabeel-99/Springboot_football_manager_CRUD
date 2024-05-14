package com.example.footballManager.controller.restController;

import com.example.footballManager.model.League;
import com.example.footballManager.service.LeagueService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leagues")
public class LeagueRestController {
    private final LeagueService leagueService;

    @Autowired
    public LeagueRestController(LeagueService leagueService){
        this.leagueService = leagueService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<League>> getAllLeagues(){
        List<League> leagues = leagueService.getAllLeagues();
        return ResponseEntity.ok(leagues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<League> getLeagueById(@PathVariable("id") Long id){
        League league = leagueService.getLeagueById(id);
        if(league != null){
            return ResponseEntity.ok(league);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<League> createLeague(@RequestBody League league){
        League createdLeague = leagueService.saveLeague(league);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeague);
    }

    @PutMapping("/{id}")
    public ResponseEntity<League> updateLeague(@PathVariable("id") Long id, @RequestBody League league){
        League existingLeague = leagueService.getLeagueById(id);
        if(existingLeague != null){
            league.setId(id);
            League updatedLeague = leagueService.saveLeague(league);
            return ResponseEntity.ok(updatedLeague);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeague(@PathVariable("id") Long id){
        League exisitingLeague = leagueService.getLeagueById(id);
        if(exisitingLeague != null){
            leagueService.deletePlayerById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
