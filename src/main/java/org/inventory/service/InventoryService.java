package org.inventory.service;

import org.inventory.model.InventoryData;
import org.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public void processInventoryMessage(String key, String value) {
        // Here we're assuming "value" is in JSON format and converting it to InventoryData
        System.out.println("Processing inventory message: Key=" + key + ", Value=" + value);

        // (Optional): Parse or transform JSON to InventoryData object
        // Assuming value has something like {"sku": "abc", "quantity": 5}
        InventoryData inventoryData = new InventoryData();
        inventoryData.setMessageKey(key);
        inventoryData.setMessageValue(value);

        // Save the data with the repository - Mongo JPA for DB
        inventoryRepository.insert(inventoryData);
        System.out.println("Message successfully saved to the database.");}
}