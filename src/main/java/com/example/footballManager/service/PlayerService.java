package com.example.footballManager.service;

import com.example.footballManager.model.Player;
import com.example.footballManager.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Player with ID %d not found", id)));
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}
