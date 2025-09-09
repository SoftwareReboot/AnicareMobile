package com.anicarebackend.anicare.domain.dto;

import java.util.UUID;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDto {
    private UUID id;
    private UUID petId;
    private UUID vetId;
    private LocalDate date;
    private String reason;
    private String status;
}
