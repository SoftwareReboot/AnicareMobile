package com.anicarebackend.anicare.services.Impl;

import org.springframework.stereotype.Service;
import com.anicarebackend.anicare.domain.dto.PetDto;
import com.anicarebackend.anicare.domain.entities.Pet;
import com.anicarebackend.anicare.repo.PetRepo;
import com.anicarebackend.anicare.services.PetService;
import com.anicarebackend.anicare.mapper.impl.PetMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepo petRepo;
    private final PetMapper petMapper;

    public PetServiceImpl(PetRepo petRepo, PetMapper petMapper){
        this.petRepo = petRepo;
        this.petMapper = petMapper;
    }

    @Override
    public PetDto createPet(PetDto dto) {
        Pet pet = petMapper.toEntity(dto);
        Pet savedPet = petRepo.save(pet);
        return petMapper.toDto(savedPet);
    }

    @Override
    public List<PetDto> getAllPet() {
        return petRepo.findAll()
        .stream()
        .map(petMapper :: toDto)
        .collect(Collectors.toList());

    }

    @Override
    public PetDto getPetById(UUID id) {
        Pet pet = petRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Pet not found with Id: " + id));
        return petMapper.toDto(pet);
    }

    @Override
    public PetDto updatePet(UUID id, PetDto dto) {
        Pet existingPet = petRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Pet not found with Id: " + id));

        existingPet.setName(dto.getName());
        existingPet.setAge(dto.getAge());
        existingPet.setBreed(dto.getBreed());
        existingPet.setType(dto.getType());
        
        Pet updatedPet = petRepo.save(existingPet);
        return  petMapper.toDto(updatedPet);
    }

    @Override
    public void deletePet(UUID id) {
        Pet pet = petRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Pet not found with Id: " + id));
        petRepo.delete(pet);
    }

    @Override
    public List<PetDto> getPetsByUserId(UUID userId) {
       List<Pet> pets = petRepo.findByOwnerId(userId);
       return pets.stream()
       .map(petMapper :: toDto)
       .collect(Collectors.toList());
    }

    
}
