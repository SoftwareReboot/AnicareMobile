package com.anicarebackend.anicare.services;

import com.anicarebackend.anicare.domain.dto.PetDto;
import java.util.List;
import java.util.UUID;

public interface PetService {
    PetDto createPet(PetDto dto);
    List<PetDto> getAllPet();
    PetDto getPetById(UUID id);
    PetDto updatePet(UUID id, PetDto dto);
    void deletePet(UUID id);
    List<PetDto> getPetsByUserId(UUID userId);
}
