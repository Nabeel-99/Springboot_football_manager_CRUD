package com.example.footballManager.controller.webController;

import com.example.footballManager.model.Team;
import com.example.footballManager.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/list")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "team-list";
    }

    @GetMapping("/form")
    public String showTeamForm(Model model) {
        model.addAttribute("team", new Team());
        return "team-form";
    }


    @PostMapping("/save")
    public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "team-form";
        }
        teamService.saveTeam(team);
        return "redirect:/teams/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Team team = teamService.getTeamById(id);
        if (team != null) {
            model.addAttribute("team", team);
            return "team-form";
        } else {
            return "redirect:/teams/list";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateTeam(@Valid @PathVariable("id") Long id, @ModelAttribute Team updatedTeam, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "team-form";
        }
        Team existingTeam = teamService.getTeamById(id);

        if (existingTeam != null) {
            existingTeam.setName(updatedTeam.getName());
            existingTeam.setCity(updatedTeam.getCity());

            teamService.saveTeam(existingTeam);
        }

        return "redirect:/teams/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteTeamById(id);
        return "redirect:/teams/list";
    }
}
