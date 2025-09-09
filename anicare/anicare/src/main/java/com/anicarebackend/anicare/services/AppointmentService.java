package com.anicarebackend.anicare.services;

import com.anicarebackend.anicare.domain.dto.AppointmentDto;
import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto dto);
    List<AppointmentDto> getAppointmentsByPetId(UUID petId);
    List<AppointmentDto> getAppointmentsByVetId(UUID vetId);
    AppointmentDto getAppointmentById(UUID id);
    AppointmentDto updateAppointment(UUID id, AppointmentDto dto);
    void deleteAppointment(UUID id);
}
