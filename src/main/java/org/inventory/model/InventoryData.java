package org.inventory.model;

import jakarta.persistence.Entity;

@Entity
public class InventoryData {

    private String messageKey;

    private String messageValue;

    // Getters and Setters
    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }
}