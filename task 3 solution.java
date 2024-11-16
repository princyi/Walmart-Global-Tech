```plaintext
Entities:

+-----------------+         +--------------------+         +------------------+
|  Manufacturer   |         |     Product        |         |     Animal       |
+-----------------+         +--------------------+         +------------------+
| manufacturer_id |---+     | product_id         |     +---| animal_id        |
| name            |   |     | name              |     |   | type            |
+-----------------+   |     | weight (nullable) |     |   +------------------+
                     |     | flavor (nullable)  |     |   
                     |     | material (nullable)|     |
                     |     | durability (nullable)|   |
                     |     | color (nullable)   |    |
                     |     | size (nullable)    |    |
                     |     | care_instructions  |    |
                     |     | manufacturer_id    |    |
                     |     +--------------------+    |
                     |                                |
                     +---------------------------------+

+-----------------+         +--------------------+         +----------------------+
|    Customer     |         |    Transaction     |         |      Location        |
+-----------------+         +--------------------+         +----------------------+
| customer_id     |     +---| transaction_id    |     +---| location_id          |
| name            |     |   | customer_id       |     |   | name                 |
| email           |     |   | transaction_date  |     |   | zip_code             |
+-----------------+     |   +--------------------+     +---+----------------------+
                      
+-----------------+         +--------------------+
|    Shipment     |         |  Product_Animal    |
+-----------------+         +--------------------+
| shipment_id     |     +---| product_id         |
| origin_id       |     |   | animal_id          |
| destination_id  |     |   +--------------------+
| product_id      |     
| quantity        |
+-----------------+
```

### Entity Relationships:
1. **Manufacturer** to **Product**: One-to-Many (each product is produced by one manufacturer).
2. **Product** to **Animal**: Many-to-Many (each product can be suitable for multiple animals).
3. **Customer** to **Transaction**: One-to-Many (each customer can make multiple transactions).
4. **Transaction** to **Product**: Many-to-Many (each transaction can include multiple products).
5. **Location** to **Shipment**: One-to-Many for both origin and destination (each shipment originates from one location and is delivered to another).
6. **Shipment** to **Product**: One-to-Many (each shipment can include multiple products, tracked with quantities).

