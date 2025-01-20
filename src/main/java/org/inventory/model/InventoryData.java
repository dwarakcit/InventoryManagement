package org.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_messages") // Replace with your desired table name
public class InventoryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(name = "message_key")
    private String messageKey;

    @Column(name = "message_value", length = 4000) // Customize for longer data
    private String messageValue;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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