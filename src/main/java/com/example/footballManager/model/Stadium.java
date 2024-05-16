package com.example.footballManager.model;

import com.example.footballManager.model.AbstractEntity;
import com.example.footballManager.model.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = "teams")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "stadium")
@SequenceGenerator(name = "stadium_generator", sequenceName = "stadium_sequence", allocationSize = 1)
public class Stadium extends AbstractEntity<Long> {

    // Attributes
    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 3, max = 100, message = "Stadium name must be between 3 and 100")
    @NotNull(message = "Field is required")
    private String name;

    @Column(name = "location", nullable = false)
    @Size(min = 3, max = 100, message = "Location must be between 3 and 100")
    @NotNull(message = "Field is required")
    private String location;

    @Column(name = "capacity", nullable = false)
    @NotNull(message = "Field is required")
    private int capacity;

    // Relationships

    // One-to-Many relationship with Team
    @JsonIgnore
    @OneToMany(mappedBy = "stadium", cascade = CascadeType.ALL)
    private Set<Team> teams;
}
