package com.anicarebackend.anicare.mapper.impl;

import org.springframework.stereotype.Component;

import com.anicarebackend.anicare.domain.entities.Pet;
import com.anicarebackend.anicare.domain.dto.PetDto;
import com.anicarebackend.anicare.mapper.Mapper;

@Component
public class PetMapper implements Mapper<Pet, PetDto> {

    @Override
    public Pet toEntity(PetDto dto) {
        if (dto == null) {
            return null;
        }
        return Pet.builder()
        .id(dto.getId())
        .name(dto.getName())
        .type(dto.getType())
        .breed(dto.getBreed())
        .age(dto.getAge())
        .build();
    }

    @Override
    public PetDto toDto(Pet entity) {
       if (entity == null) {
        return null;
       }
       return PetDto.builder()
       .id(entity.getId())
       .name(entity.getName())
       .type(entity.getType())
       .breed(entity.getBreed())
       .age(entity.getAge())
       .build();
    }
    
}
