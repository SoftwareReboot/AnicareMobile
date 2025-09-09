package com.anicarebackend.anicare.services;

import com.anicarebackend.anicare.domain.dto.VetDto;
import java.util.List;
import java.util.UUID;

public interface VeterinarianService {
    VetDto createVet(VetDto dto);
    VetDto getVetById(UUID id);
    List<VetDto> getAllVets();
    VetDto updateVet(UUID id, VetDto dto);
    void deleteVet(UUID id);
}
