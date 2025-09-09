package com.anicarebackend.anicare.mapper.impl;

import org.springframework.stereotype.Component;

import com.anicarebackend.anicare.domain.entities.Appointment;
import com.anicarebackend.anicare.domain.dto.AppointmentDto;
import com.anicarebackend.anicare.mapper.Mapper;

@Component
public class AppointmentMapper implements Mapper<Appointment, AppointmentDto> {

    @Override
    public Appointment toEntity(AppointmentDto dto) {
        if (dto == null) {
            return null;
        }
       return Appointment.builder()
       .id(dto.getId())
       .date(dto.getDate())
       .reason(dto.getReason())
       .status(dto.getStatus())
       .build();
    }

    @Override
    public AppointmentDto toDto(Appointment entity) {
        if (entity == null) {
            return null;
        }
        return AppointmentDto.builder()
        .id(entity.getId())
        .date(entity.getDate())
        .reason(entity.getReason())
        .status(entity.getStatus())
        .petId(entity.getPetId().getId())
        .vetId(entity.getVetId().getId())
        .build();
    }
    
}
