package com.pharmacy.ms.inventory.management.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PrescriptionResponseDto {
    private Long id;
    private String patientName;
    private String medicationName;
    private String dosage;
    private String prescribedBy;
    private LocalDate prescriptionDate;
    private LocalDateTime createdAt;

    // Getters and Setters
}




