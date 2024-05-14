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

@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "league")
@SequenceGenerator(name = "league_generator", sequenceName = "league_sequence", allocationSize = 1)
public class League extends AbstractEntity<Long> {

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 3, max = 100, message = "League name must be between 3 and 100 characters")
    @NotNull(message = "Field is required")
    private String name;

    @Column(name = "country", nullable = false)
    @Size(min = 3, max = 100, message = "Country must be between 3 and 100 characters")
    @NotNull(message = "Field is required")
    private String country;

    @Column(name = "season", nullable = false)
    @Size(min = 3, max = 100, message = "Season must be between 3 and 100 characters")
    @NotNull(message = "Field is required")
    private String season;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private Set<Team> teams;
}
