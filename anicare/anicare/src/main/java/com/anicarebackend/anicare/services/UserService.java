package com.anicarebackend.anicare.services;

import com.anicarebackend.anicare.domain.dto.UserDto;
import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto createUsers(UserDto dto);
    List<UserDto> getAllUsers();
    UserDto getusersById(UUID id);
    UserDto updateUsers(UUID id, UserDto dto);
    void deleteUsers(UUID id);
}
