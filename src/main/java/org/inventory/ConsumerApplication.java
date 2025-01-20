package org.inventory;

import org.inventory.consumer.KafkaInventoryConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
})
@ComponentScan(basePackages = {"org.inventory"})
public class ConsumerApplication implements CommandLineRunner {

    @Autowired
    private KafkaInventoryConsumer kafkaInventoryConsumer;

    public static void main(String[] args) {
        System.out.println("Starting Inventory Consumer...");
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Start the Kafka Consumer
        kafkaInventoryConsumer.startConsumer();
    }
}