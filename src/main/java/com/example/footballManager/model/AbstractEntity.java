package com.example.footballManager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class AbstractEntity<ID extends Serializable> implements Serializable {
    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private ID id;

    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime created;

    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updated;
}
