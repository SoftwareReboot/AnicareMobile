package com.anicarebackend.anicare.mapper.impl;

import java.util.stream.Collectors;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anicarebackend.anicare.domain.entities.User;
import com.anicarebackend.anicare.domain.dto.UserDto;
import com.anicarebackend.anicare.domain.entities.Pet;
import com.anicarebackend.anicare.mapper.Mapper;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    private final PetMapper petMapper;

  
    public UserMapper(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    @Override
    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        User.UserBuilder userBuilder = User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail());

        //  map pets if present
        if (dto.getPets() != null) {
            List<Pet> pets = dto.getPets().stream()
                    .map(petMapper::toEntity)
                    .collect(Collectors.toList());
            userBuilder.pets(pets);
        }

        return userBuilder.build();
    }

    @Override
    public UserDto toDto(User entity) {
        if (entity == null) {
            return null;
        }

        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .pets(entity.getPets() != null
                        ? entity.getPets().stream()
                                .map(petMapper::toDto)
                                .collect(Collectors.toList())
                        : List.of())
                .build();
    }
}
