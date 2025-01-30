package com.pharmacy.ms.inventory.management.service;

import com.pharmacy.ms.inventory.management.dto.request.PrescriptionRequestDto;
import com.pharmacy.ms.inventory.management.dto.response.PrescriptionResponseDto;
import com.pharmacy.ms.inventory.management.model.PrescriptionEntity;
import com.pharmacy.ms.inventory.management.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    // Create a new prescription
    public PrescriptionResponseDto createPrescription(PrescriptionRequestDto requestDto) {
        PrescriptionEntity prescription = new PrescriptionEntity();
        prescription.setPatientName(requestDto.getPatientName());
        prescription.setMedicationName(requestDto.getMedicationName());
        prescription.setDosage(requestDto.getDosage());
        prescription.setPrescribedBy(requestDto.getPrescribedBy());
        prescription.setPrescriptionDate(requestDto.getPrescriptionDate());

        PrescriptionEntity savedPrescription = prescriptionRepository.save(prescription);
        return mapToResponseDto(savedPrescription);
    }

    // Get all prescriptions
    public List<PrescriptionResponseDto> getAllPrescriptions() {
        return prescriptionRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    // Get prescription by ID
    public PrescriptionResponseDto getPrescriptionById(Long id) {
        Optional<PrescriptionEntity> prescriptionOptional = prescriptionRepository.findById(id);
        return prescriptionOptional.map(this::mapToResponseDto).orElse(null);
    }

    // Delete prescription by ID
    public boolean deletePrescription(Long id) {
        if (prescriptionRepository.existsById(id)) {
            prescriptionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Update prescription by ID
    public PrescriptionResponseDto updatePrescription(Long id, PrescriptionRequestDto requestDto) {
        Optional<PrescriptionEntity> prescriptionOptional = prescriptionRepository.findById(id);

        if (prescriptionOptional.isPresent()) {
            PrescriptionEntity prescription = prescriptionOptional.get();
            prescription.setPatientName(requestDto.getPatientName());
            prescription.setMedicationName(requestDto.getMedicationName());
            prescription.setDosage(requestDto.getDosage());
            prescription.setPrescribedBy(requestDto.getPrescribedBy());
            prescription.setPrescriptionDate(requestDto.getPrescriptionDate());

            PrescriptionEntity updatedPrescription = prescriptionRepository.save(prescription);
            return mapToResponseDto(updatedPrescription);
        }
        return null; // Return null if the prescription is not found
    }

    // Helper method to map PrescriptionEntity to PrescriptionResponseDto
    private PrescriptionResponseDto mapToResponseDto(PrescriptionEntity prescription) {
        PrescriptionResponseDto dto = new PrescriptionResponseDto();
        dto.setId(prescription.getId());
        dto.setPatientName(prescription.getPatientName());
        dto.setMedicationName(prescription.getMedicationName());
        dto.setDosage(prescription.getDosage());
        dto.setPrescribedBy(prescription.getPrescribedBy());
        dto.setPrescriptionDate(prescription.getPrescriptionDate());
        dto.setCreatedAt(prescription.getCreatedAt());
        return dto;
    }
}
