package com.anicarebackend.anicare.services.Impl;

import org.springframework.stereotype.Service;
import com.anicarebackend.anicare.domain.dto.AppointmentDto;
import com.anicarebackend.anicare.domain.entities.Appointment;
import com.anicarebackend.anicare.mapper.impl.AppointmentMapper;
import com.anicarebackend.anicare.repo.AppointmentRepo;
import com.anicarebackend.anicare.services.AppointmentService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    public final AppointmentRepo appointmentRepo;
    public final AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo, AppointmentMapper appointmentMapper){
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto dto) {
        Appointment appointment = appointmentMapper.toEntity(dto);
        Appointment savedAppointment = appointmentRepo.save(appointment);
        return appointmentMapper.toDto(savedAppointment);
    }

    @Override
    public List<AppointmentDto> getAppointmentsByPetId(UUID petId) {
        List<Appointment> appointments = appointmentRepo.findByPetId(petId);
        return appointments.stream()
        .map(appointmentMapper :: toDto)
        .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDto> getAppointmentsByVetId(UUID vetId) {
        List<Appointment> appointments = appointmentRepo.findByVetId(vetId);
        return appointments.stream()
        .map(appointmentMapper :: toDto)
        .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto getAppointmentById(UUID id) {
        Appointment appointment = appointmentRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Appointment not found: " + id));
        return appointmentMapper.toDto(appointment);
    }

    @Override
    public AppointmentDto updateAppointment(UUID id, AppointmentDto dto) {
        Appointment existingAppointment = appointmentRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Appointment not found with Id: " + id));

        existingAppointment.setDate(dto.getDate());
        existingAppointment.setReason(dto.getReason());
        existingAppointment.setStatus(dto.getStatus());

        Appointment updatedAppointment = appointmentRepo.save(existingAppointment);
        return appointmentMapper.toDto(updatedAppointment);
    }

    @Override
    public void deleteAppointment(UUID id) {
        Appointment appointment = appointmentRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Appointment not found with Id: " + id));
        appointmentRepo.delete(appointment);
    }

    
}
