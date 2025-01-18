package org.inventory.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.Scanner;

public class KafkaInventoryProducer {
    public static void main(String[] args) {
        // Kafka Producer Configuration
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092"); // Kafka broker address
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create Kafka Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Get input from the user
        Scanner scanner = new Scanner(System.in);

        // Define the topic and message
        String topic = "inventoryTopic"; // Replace with your Kafka topic name
        //String key = "item1";            // Optional key for the message
        //String value = "This is a test message for Kafka from Dwarak"; // Message value

        System.out.println("Enter the item ID:");
        String key = scanner.nextLine(); // Input for message key

        System.out.println("Enter the item Name:");
        String value = scanner.nextLine(); // Input for message value

        try {
            // Send the message
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
            producer.send(record, (RecordMetadata metadata, Exception exception) -> {
                if (exception == null) {
                    System.out.printf("Message sent successfully! Topic: %s, Partition: %d, Offset: %d%n",
                            metadata.topic(), metadata.partition(), metadata.offset());
                } else {
                    System.err.printf("Message sending failed: %s%n", exception.getMessage());
                }
            });
        } finally {
            // Close the producer to release resources
            producer.close();
        }
    }
}