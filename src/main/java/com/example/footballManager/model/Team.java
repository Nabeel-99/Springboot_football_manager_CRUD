package com.example.footballManager.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "team")
@SequenceGenerator(name = "team_generator", sequenceName = "team_sequence", allocationSize = 1)
public class Team extends AbstractEntity<Long>{

    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 100, message = "Team name must be between 3 and 100")
    @NotNull(message = "Field is required")
    private String name;

    @Column(name = "city", nullable = false)
    @Size(min = 3, max = 100, message = "Location must be between 3 and 100")
    @NotNull(message = "Field is required")
    private String city;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Player> players;

    // Many-to-One relationship with League
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    private League league;

    // Many-to-One relationship with Stadium
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    // One-to-One relationship with Kit
    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL)
    private Kit kit;


}

