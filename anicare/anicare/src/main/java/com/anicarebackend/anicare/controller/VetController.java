package com.anicarebackend.anicare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anicarebackend.anicare.domain.dto.VetDto;
import com.anicarebackend.anicare.services.VeterinarianService;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/vets")
public class VetController {
    private final VeterinarianService vetService;

    public VetController(VeterinarianService vetService){
        this.vetService = vetService;
    }

    @PostMapping
    public ResponseEntity<VetDto> createVet(@RequestBody VetDto vetDto){
        VetDto createdVet = vetService.createVet(vetDto);
        return ResponseEntity.status(201).body(createdVet);
    }

    @GetMapping
    public ResponseEntity<List<VetDto>> getAllVets(){
        return ResponseEntity.ok(vetService.getAllVets());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<VetDto> getVetsById(@PathVariable UUID Id){
        return ResponseEntity.ok(vetService.getVetById(Id));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<VetDto> updateVets(@PathVariable UUID Id, @RequestBody VetDto vetDto){
        VetDto updatedVets = vetService.updateVet(Id, vetDto);
        return ResponseEntity.ok(updatedVets);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<VetDto> deleteVets(@PathVariable UUID Id){
        vetService.deleteVet(Id);
        return ResponseEntity.noContent().build();
    }


}
