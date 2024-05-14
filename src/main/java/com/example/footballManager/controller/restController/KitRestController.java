package com.example.footballManager.controller.restController;

import com.example.footballManager.model.Kit;
import com.example.footballManager.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kits")
public class KitRestController {

    private final KitService kitService;

    @Autowired
    public KitRestController(KitService kitService){
        this.kitService = kitService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Kit>> getAllKits(){
       List<Kit> kits = kitService.getAllKits();
       return ResponseEntity.ok(kits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kit> getKitById(@PathVariable("id") Long id){
        Kit kit = kitService.getKitById(id);
        if(kit != null){
            return ResponseEntity.ok(kit);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Kit> createKit(@RequestBody Kit kit){
        Kit createdKit = kitService.saveKit(kit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kit> updateKit(@PathVariable("id") Long id, @RequestBody Kit kit){
        Kit existingKit = kitService.getKitById(id);
        if(existingKit != null){
            kit.setId(id);
            Kit updatedKit = kitService.saveKit(kit);
            return ResponseEntity.ok(updatedKit);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKit(@PathVariable("id") Long id){
        Kit existingKit = kitService.getKitById(id);
        if(existingKit != null){
            kitService.deleteKitById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
