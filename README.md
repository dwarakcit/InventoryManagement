# Project Name: InventoryManagement
Project Description:
This project demonstrates a basic inventory management system that leverages Apache Kafka for real-time data streaming and Azure Cosmos DB for reliable and scalable data storage.

Key Features:
Kafka Producer:
- Publishes inventory events to a designated Kafka topic.

Kafka Consumer:
- Subscribes to the inventory events topic.
- Processes incoming events and persists relevant data to Azure Cosmos DB.
- Implements data transformations or aggregations (if needed) before storage.

Azure Cosmos DB Integration:
- Utilizes Azure Cosmos DB as the primary data store for inventory information.
