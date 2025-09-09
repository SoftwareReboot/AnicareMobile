package com.anicarebackend.anicare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anicarebackend.anicare.domain.dto.PetDto;
import com.anicarebackend.anicare.services.PetService;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto petDto){
        PetDto createdPet = petService.createPet(petDto);
        return ResponseEntity.status(201).body(createdPet);
    }

    @GetMapping
    public ResponseEntity<List<PetDto>> getAllPets(){
        return ResponseEntity.ok(petService.getAllPet());
    }
    
    @GetMapping("/{Id}")
    public ResponseEntity<PetDto> getPetById(@PathVariable UUID Id){
        return ResponseEntity.ok(petService.getPetById(Id));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<PetDto> updatePets(@PathVariable UUID Id, @RequestBody PetDto petDto){
        PetDto updatedPets = petService.updatePet(Id, petDto);
        return ResponseEntity.ok(updatedPets);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<PetDto> deletePets(@PathVariable UUID Id){
        petService.deletePet(Id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}/pets")
    public ResponseEntity<List<PetDto>> getPetsByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(petService.getPetsByUserId(userId));
    }
}
