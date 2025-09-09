package com.anicarebackend.anicare.domain.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VetDto {
    private UUID Id;
    private String name;
    private String specialization;
    private String email;    
}
