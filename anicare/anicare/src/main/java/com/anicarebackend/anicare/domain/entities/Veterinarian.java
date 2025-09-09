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
@Table(name = "vet")
@Builder
public class Veterinarian {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "VetId", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "Name", nullable = false, updatable = false)
    private String name;

    @Column(name = "Specialization", nullable = false, updatable = false)
    private String speciality;

    @Column(name = "Email", nullable = false, updatable = true)
    private String email;

     @OneToMany(mappedBy = "vet", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true) //vets can have many appointments
    private List<Appointment> appointments;
}
