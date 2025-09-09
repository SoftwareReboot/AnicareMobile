package com.anicarebackend.anicare.repo;

import com.anicarebackend.anicare.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID>{
    
}
