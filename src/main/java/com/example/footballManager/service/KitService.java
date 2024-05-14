package com.example.footballManager.service;

import com.example.footballManager.model.Kit;
import com.example.footballManager.repository.KitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitService {

    private final KitRepository kitRepository;

    @Autowired
    public KitService(KitRepository kitRepository){
        this.kitRepository = kitRepository;
    }
    public void deleteKitById(Long id) {
        kitRepository.deleteById(id);
    }

    public Kit getKitById(Long id) {
        return kitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Kit with ID %d not found", id)));
    }

    public Kit saveKit(Kit kit) {
        return kitRepository.save(kit);
    }

    public List<Kit> getAllKits() {
        return kitRepository.findAll();
    }
}
