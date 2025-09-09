package com.anicarebackend.anicare.repo;

import com.anicarebackend.anicare.domain.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, UUID>{
    List<Appointment> findByPetId(UUID petId);
    List<Appointment> findByVetId(UUID vetId);
}
