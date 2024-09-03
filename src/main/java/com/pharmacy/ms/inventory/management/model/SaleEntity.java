package com.pharmacy.ms.inventory.management.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "quantity_sold", nullable = false)
    private int quantitySold;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "sale_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime saleDate;

    // Getters and Setters
}
