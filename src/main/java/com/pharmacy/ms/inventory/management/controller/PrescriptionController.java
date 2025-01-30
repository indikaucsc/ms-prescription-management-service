package com.pharmacy.ms.inventory.management.controller;

import com.pharmacy.ms.inventory.management.dto.request.PrescriptionRequestDto;
import com.pharmacy.ms.inventory.management.dto.response.PrescriptionResponseDto;
import com.pharmacy.ms.inventory.management.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    // Create a new prescription
    @PostMapping
    public ResponseEntity<PrescriptionResponseDto> createPrescription(@RequestBody PrescriptionRequestDto requestDto) {
        PrescriptionResponseDto responseDto = prescriptionService.createPrescription(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // Get all prescriptions
    @GetMapping
    public ResponseEntity<List<PrescriptionResponseDto>> getAllPrescriptions() {
        return new ResponseEntity<>(prescriptionService.getAllPrescriptions(), HttpStatus.OK);
    }

    // Get prescription by ID
    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDto> getPrescriptionById(@PathVariable Long id) {
        PrescriptionResponseDto responseDto = prescriptionService.getPrescriptionById(id);
        if (responseDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP 404 if not found
        }
        return new ResponseEntity<>(responseDto, HttpStatus.OK); // HTTP 200 if found
    }

    // Delete prescription by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        boolean isDeleted = prescriptionService.deletePrescription(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // HTTP 204 if successfully deleted
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP 404 if prescription not found
        }
    }

    // Update prescription by ID
    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDto> updatePrescription(
            @PathVariable Long id,
            @RequestBody PrescriptionRequestDto requestDto) {
        PrescriptionResponseDto updatedPrescription = prescriptionService.updatePrescription(id, requestDto);
        if (updatedPrescription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP 404 if prescription not found
        }
        return new ResponseEntity<>(updatedPrescription, HttpStatus.OK); // HTTP 200 with updated prescription
    }
}
