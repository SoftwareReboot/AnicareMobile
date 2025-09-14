package com.anicarebackend.anicare.domain.entities;

import java.util.UUID;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "veterinarians")
@Builder
public class Veterinarian {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vet_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "veterinarian", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;
}
