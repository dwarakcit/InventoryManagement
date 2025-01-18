package org.inventory.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaInventoryConsumer {
    public static void main(String[] args) {
        // Set consumer properties
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092"); // Kafka broker address
        properties.put("group.id", "inventory-consumer-group"); // Consumer group ID
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // Key deserializer
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // Value deserializer
        properties.put("auto.offset.reset", "earliest"); // Option to read messages from the beginning (if no previous offset is committed)

        // Create KafkaConsumer instance
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Subscribe to the topic
        String topic = "inventoryTopic"; // Replace this with your topic name
        consumer.subscribe(Collections.singletonList(topic)); // Can subscribe to multiple topics

        System.out.println("Consumer is listening to topic: " + topic);

        try {
            // Poll for messages in an infinite loop
            while (true) {
                // Fetch records from Kafka with a timeout of 1 second
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                
                // Process each record
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Received message:\nKey: %s\nValue: %s\nPartition: %d\nOffset: %d\n\n",
                            record.key(), record.value(), record.partition(), record.offset());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the consumer before exiting
            consumer.close();
        }
    }
}