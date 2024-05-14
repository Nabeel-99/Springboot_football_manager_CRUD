package com.example.footballManager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "kit")
@SequenceGenerator(name = "kit_generator", sequenceName = "kit_sequence", allocationSize = 1)
public class Kit extends AbstractEntity<Long> {

    // Attributes
    @Column(name = "home_jersey_color", nullable = false)
    @NotNull(message = "Field is required")
    private String homeJerseyColor;

    @Column(name = "away_jersey_color", nullable = false)
    @NotNull(message = "Field is required")
    private String awayJerseyColor;

    @Column(name = "kit_manufacturer", nullable = false)
    @NotNull(message = "Field is required")
    private String kitManufacturer;

    // Relationships

    // One-to-One relationship with Team
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", unique = true)
    private Team team;
}
