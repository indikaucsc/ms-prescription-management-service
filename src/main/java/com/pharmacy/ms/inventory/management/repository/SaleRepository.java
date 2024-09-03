package com.pharmacy.ms.inventory.management.repository;


import com.pharmacy.ms.inventory.management.model.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}