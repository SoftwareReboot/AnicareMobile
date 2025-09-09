package com.anicarebackend.anicare.mapper.impl;

import org.springframework.stereotype.Component;

import com.anicarebackend.anicare.domain.entities.Veterinarian;
import com.anicarebackend.anicare.domain.dto.VetDto;
import com.anicarebackend.anicare.mapper.Mapper;

@Component
public class VetMapper implements Mapper<Veterinarian, VetDto> {

    @Override
    public Veterinarian toEntity(VetDto dto) {
      if (dto == null) {
        return null;
      }
      return Veterinarian.builder()
      .id(dto.getId())
      .name(dto.getName())
      .speciality(dto.getSpecialization())
      .email(dto.getEmail())
      .build();
    }

    @Override
    public VetDto toDto(Veterinarian entity) {
        if (entity == null) {
            return null;
        }
        return VetDto.builder()
        .Id(entity.getId())
        .name(entity.getName())
        .specialization(entity.getSpeciality())
        .email(entity.getEmail())
        .build();
    }
    
}
