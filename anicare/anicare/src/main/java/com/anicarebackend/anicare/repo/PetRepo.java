package com.anicarebackend.anicare.repo;

import com.anicarebackend.anicare.domain.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface PetRepo extends JpaRepository<Pet, UUID> {
    List<Pet> findByOwnerId(UUID ownerId);
} 
