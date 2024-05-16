package com.example.footballManager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true, exclude = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "player")
@SequenceGenerator(name = "player_generator", sequenceName = "player_sequence", allocationSize = 1)
public class Player extends AbstractEntity<Long>{

    ///positions
    public enum Position{
        FORWARD,
        MIDFIELDER,
        DEFENDER,
        GOALKEEPER
    }


    @Column(name = "first_name", nullable = false)
    @Size(min = 3, max = 100, message = "First name must be between 3 and 100 characters")
    @NotNull(message = "Field is required")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 3, max = 100, message = "Last name must be between 3 and 100 characters")
    @NotNull(message = "Field is required")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "position", nullable = false)
    @NotNull(message = "Field is required")
    private Position position;

    @Column(name = "club", nullable = false)
    @Size(min = 3, max = 100, message = "Club must be between 3 and 100 characters")
    @NotNull(message = "Field is required")
    private String club;

    @Column(name = "shirt_number", nullable = false)
    @NotNull(message = "Field is required")
    private int shirtNumber;

    //relationship with Team
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


}
