package com.anicarebackend.anicare.domain.entities;

import java.util.UUID;
import java.time.LocalDate;

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
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Appointment_id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "Pet_Id", nullable = false)
    private Pet petId;

    @ManyToOne
    @JoinColumn(name = "Vet_Id", nullable = false)
    private Veterinarian vetId;

    @Column(name = "Reason", nullable = false, updatable = false)
    private String reason;

    @Column(name = "Status", nullable = false, updatable = true)
    private String status;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}
