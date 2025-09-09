package com.anicarebackend.anicare.controller;

import com.anicarebackend.anicare.domain.dto.UserDto;
import com.anicarebackend.anicare.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUser = userService.createUsers(userDto);
        return ResponseEntity.status(201).body(createdUser);
    }
    
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID Id){
        return ResponseEntity.ok(userService.getusersById(Id));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<UserDto> updateUsers(@PathVariable UUID id, @RequestBody UserDto userDto){
        UserDto updatedUser = userService.updateUsers(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<UserDto> deleteUsers (@PathVariable UUID Id){
        userService.deleteUsers(Id);
        return ResponseEntity.noContent().build();
    }
}
