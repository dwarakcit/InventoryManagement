package org.inventory.repository;

import org.inventory.model.InventoryData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<InventoryData, String> {

}
