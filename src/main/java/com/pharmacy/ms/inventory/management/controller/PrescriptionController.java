package com.pharmacy.ms.inventory.management.controller;


import com.pharmacy.ms.inventory.management.dto.request.PrescriptionRequestDto;
import com.pharmacy.ms.inventory.management.dto.response.PrescriptionResponseDto;
import com.pharmacy.ms.inventory.management.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<PrescriptionResponseDto> createPrescription(@RequestBody PrescriptionRequestDto requestDto) {
        PrescriptionResponseDto responseDto = prescriptionService.createPrescription(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionResponseDto>> getAllPrescriptions() {
        return new ResponseEntity<>(prescriptionService.getAllPrescriptions(), HttpStatus.OK);
    }
}
