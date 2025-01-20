package org.inventory.consumer;

import org.inventory.consumer.KafkaInventoryConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private KafkaInventoryConsumer kafkaInventoryConsumer;

    public static void main(String[] args) {
        System.out.println("Starting Inventory Consumer...");
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        // Start the Kafka Consumer
        kafkaInventoryConsumer.startConsumer();
    }
}