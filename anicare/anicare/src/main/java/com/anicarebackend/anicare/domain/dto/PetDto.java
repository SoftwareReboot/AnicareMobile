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
public class PetDto {
    private UUID id;
    private String name;
    private String type;
    private String breed;
    private int age;
    private UUID ownerId;
}
