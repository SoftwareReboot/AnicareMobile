package com.anicarebackend.anicare.repo;

import com.anicarebackend.anicare.domain.entities.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface VetRepo extends JpaRepository<Veterinarian, UUID>{
    
}
