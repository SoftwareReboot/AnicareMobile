package com.anicarebackend.anicare.services.Impl;

import com.anicarebackend.anicare.domain.dto.UserDto;
import com.anicarebackend.anicare.domain.entities.User;
import com.anicarebackend.anicare.repo.UserRepo;
import com.anicarebackend.anicare.mapper.impl.UserMapper;
import com.anicarebackend.anicare.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper){
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUsers(UserDto dto) {
        User user = userMapper.toEntity(dto);
        User savedUser = userRepo.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll()
        .stream()
        .map(userMapper :: toDto)
        .collect(Collectors.toList());
    }

    @Override
    public UserDto getusersById(UUID id) {
        User user = userRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("User Not Found"));
        return userMapper.toDto(user);

    }

    @Override
    public UserDto updateUsers(UUID id, UserDto dto) {
       User existingUser = userRepo.findById(id)
       .orElseThrow(() -> new RuntimeException("User Not Found"));

       existingUser.setName(dto.getName());
       existingUser.setEmail(dto.getEmail());
       
       User updatedUser = userRepo.save(existingUser);
       return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUsers(UUID id) {
        User user = userRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("User Not Found"));
        userRepo.delete(user);
    }    
}
