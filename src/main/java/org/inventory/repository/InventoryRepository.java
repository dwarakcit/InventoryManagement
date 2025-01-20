package org.inventory.repository;

import org.inventory.model.InventoryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryData, Long> {
    // Spring Data JPA provides CRUD and Query DSL functionality out of the box
}