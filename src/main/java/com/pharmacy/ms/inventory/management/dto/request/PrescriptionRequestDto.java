package com.pharmacy.ms.inventory.management.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PrescriptionRequestDto {
    private String patientName;
    private String medicationName;
    private String dosage;
    private String prescribedBy;
    private LocalDate prescriptionDate;

    // Getters and Setters
}




