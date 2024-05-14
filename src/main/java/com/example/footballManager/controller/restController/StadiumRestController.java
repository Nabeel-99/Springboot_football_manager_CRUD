package com.example.footballManager.controller.restController;

import com.example.footballManager.model.Stadium;
import com.example.footballManager.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumRestController {

    private final StadiumService stadiumService;

    @Autowired
    public StadiumRestController(StadiumService stadiumService){
        this.stadiumService = stadiumService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stadium>> getAllStadiums(){
        List<Stadium> stadiums = stadiumService.getAllStadiums();
        return ResponseEntity.ok(stadiums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stadium> getStadiumById(@PathVariable("id") Long id){
        Stadium stadium = stadiumService.getStadiumById(id);
        if(stadium != null){
            return ResponseEntity.ok(stadium);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Stadium> createStadium(@RequestBody Stadium stadium){
        Stadium createdStadium = stadiumService.saveStadium(stadium);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStadium);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stadium> updateStadium(@PathVariable("id") Long id, @RequestBody Stadium stadium){
        Stadium existingStadium = stadiumService.getStadiumById(id);
        if(existingStadium != null){
            stadium.setId(id);
            Stadium updatedStadium = stadiumService.saveStadium(stadium);
            return ResponseEntity.ok(updatedStadium);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStadium(@PathVariable("id") Long id){
        Stadium existingStadium = stadiumService.getStadiumById(id);
        if(existingStadium != null){
            stadiumService.deleteStadiumById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
