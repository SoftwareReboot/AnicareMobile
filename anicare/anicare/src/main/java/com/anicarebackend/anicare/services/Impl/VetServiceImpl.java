package com.anicarebackend.anicare.services.Impl;

import org.springframework.stereotype.Service;
import com.anicarebackend.anicare.domain.dto.VetDto;
import com.anicarebackend.anicare.domain.entities.Veterinarian;
import com.anicarebackend.anicare.repo.VetRepo;
import com.anicarebackend.anicare.mapper.impl.VetMapper;
import com.anicarebackend.anicare.services.VeterinarianService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VetServiceImpl implements VeterinarianService{
    public final VetRepo vetRepo;
    public final VetMapper vetMapper;

    public VetServiceImpl(VetRepo vetRepo, VetMapper vetMapper){
        this.vetMapper = vetMapper;
        this.vetRepo = vetRepo;
    }

    @Override
    public VetDto createVet(VetDto dto) {
        Veterinarian vet = vetMapper.toEntity(dto);
        Veterinarian savedVet = vetRepo.save(vet);
        return vetMapper.toDto(savedVet);
    }

    @Override
    public VetDto getVetById(UUID id) {
        Veterinarian vet = vetRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Vet not found with Id: " + id));
        return vetMapper.toDto(vet);
    }

    @Override
    public List<VetDto> getAllVets() {
        return vetRepo.findAll()
        .stream()
        .map(vetMapper :: toDto)
        .collect(Collectors.toList());
    }

    @Override
    public VetDto updateVet(UUID id, VetDto dto) {
        Veterinarian existingVet = vetRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Vet not found with Id: " + id));

        existingVet.setName(dto.getName());
        existingVet.setEmail(dto.getEmail());
        existingVet.setSpecialization(dto.getSpecialization());
        
        Veterinarian updatedVet = vetRepo.save(existingVet);
        return vetMapper.toDto(updatedVet);
    }

    @Override
    public void deleteVet(UUID id) {
        Veterinarian vet = vetRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Vet not found with Id: " + id));
        vetRepo.delete(vet);
    }

    
}
