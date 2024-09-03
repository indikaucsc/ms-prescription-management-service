package com.pharmacy.ms.inventory.management.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prescriptions")
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name", nullable = false, length = 100)
    private String patientName;

    @Column(name = "medication_name", nullable = false, length = 100)
    private String medicationName;

    @Column(nullable = false, length = 50)
    private String dosage;

    @Column(name = "prescribed_by", nullable = false, length = 100)
    private String prescribedBy;

    @Column(name = "prescription_date", nullable = false)
    private LocalDate prescriptionDate;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    // Getters and Setters
}
