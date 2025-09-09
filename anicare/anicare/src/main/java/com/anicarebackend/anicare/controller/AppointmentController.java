package com.anicarebackend.anicare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anicarebackend.anicare.domain.dto.AppointmentDto;
import com.anicarebackend.anicare.services.AppointmentService;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointments(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto createdAppointments = appointmentService.createAppointment(appointmentDto);
        return ResponseEntity.status(201).body(createdAppointments);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable UUID Id){
        return ResponseEntity.ok(appointmentService.getAppointmentById(Id));
    }

    @GetMapping("/pets/{petId}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentByPetId(@PathVariable UUID petId){
        return ResponseEntity.ok(appointmentService.getAppointmentsByPetId(petId));
    }

    @GetMapping("/vets/{vetId}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentByVetId(@PathVariable UUID vetId){
        return ResponseEntity.ok(appointmentService.getAppointmentsByVetId(vetId));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<AppointmentDto> updateAppointments(@PathVariable UUID Id, @RequestBody AppointmentDto appointmentDto){
        AppointmentDto updatedAppointments = appointmentService.updateAppointment(Id, appointmentDto);
        return ResponseEntity.ok(updatedAppointments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable UUID id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

}
