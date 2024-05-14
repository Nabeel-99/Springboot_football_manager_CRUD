package com.example.footballManager.controller.webController;

import com.example.footballManager.model.Player;
import com.example.footballManager.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/list")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "player-list";
    }

    @GetMapping("/form")
    public String showPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "player-form";
    }


    @PostMapping("/save")
    public String createPlayer(@Valid @ModelAttribute("player") Player player, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "player-form";
        }
        playerService.savePlayer(player);
        return "redirect:/players/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        if (player != null) {
            model.addAttribute("player", player);
            return "player-form";
        } else {
            return "redirect:/players/list";
        }
    }

    @PostMapping("/edit/{id}")
    public String updatePlayer(@Valid @PathVariable("id") Long id, @ModelAttribute Player updatedPlayer, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "player-form";
        }
        Player existingPlayer = playerService.getPlayerById(id);
        if(existingPlayer == null){
            return "redirect:/players/list";
        }
        existingPlayer.setFirstName(updatedPlayer.getFirstName());
        existingPlayer.setLastName(updatedPlayer.getLastName());
        existingPlayer.setPosition(updatedPlayer.getPosition());
        existingPlayer.setShirtNumber(updatedPlayer.getShirtNumber());

        playerService.savePlayer(existingPlayer);

        return  "redirect:/players/list";

    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayerById(id);
        return "redirect:/players/list";
    }
}
