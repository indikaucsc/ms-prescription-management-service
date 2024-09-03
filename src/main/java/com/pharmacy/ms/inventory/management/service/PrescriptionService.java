
package com.pharmacy.ms.inventory.management.service;

import com.pharmacy.ms.inventory.management.dto.request.PrescriptionRequestDto;
import com.pharmacy.ms.inventory.management.dto.response.PrescriptionResponseDto;
import com.pharmacy.ms.inventory.management.model.PrescriptionEntity;
import com.pharmacy.ms.inventory.management.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

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

    public List<PrescriptionResponseDto> getAllPrescriptions() {
        return prescriptionRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

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

