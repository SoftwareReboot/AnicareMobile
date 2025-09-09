package com.anicarebackend.anicare.domain.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Pets")
public class Pet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Pet_Id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "Name", nullable = false, updatable = false)
    private String name;

    @Column(name = "Type", nullable = false, updatable = false)
    private String type;

    @Column(name = "Breed", nullable = false, updatable = false)
    private String breed;

    @Column(name = "Age", nullable = false, updatable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "owner_Id", nullable = false)
    private User owner;
    //many pets can have the same owner ang logic ani
}
