# Dynamic Pricing Engine

## Project Overview

The Dynamic Pricing Engine is an enterprise-level Spring Boot application that calculates the final price of a product dynamically based on configurable pricing rules.

The application supports multiple pricing strategies such as:

- Surge Pricing
- Time-Based Pricing
- Inventory-Based Pricing

The pricing rules are configurable through Admin APIs without changing the application code.

---

# Business Objective

Build a backend pricing engine capable of dynamically calculating product prices based on:

- Customer demand
- Available inventory
- Time of the day
- Configurable business rules

The application is designed using Spring Boot layered architecture and Strategy Design Pattern.

---

# Technologies Used

- Java 17
- Spring Boot 3.5.x
- Spring Data JPA
- Hibernate
- Hibernate Validator
- MySQL
- Maven
- Lombok
- Swagger (OpenAPI)
- Spring Cache

---

# Features

### Product Management

- Create Product
- Update Product
- Delete Product
- Get Product By Id
- Get All Products

---

### Pricing Rule Management

Admin can configure pricing rules.

Supported rule types:

- SURGE
- TIME_BASED
- INVENTORY_BASED

Operations:

- Create Rule
- Update Rule
- Delete Rule
- Get Rule
- Get All Rules

---

### Dynamic Pricing

The engine calculates the final product price by applying all active pricing rules according to their priority.

Example:

Base Price

↓

Surge Pricing

↓

Time-Based Pricing

↓

Inventory-Based Pricing

↓

Final Price

---

# Project Architecture

```
Controller
     ↓
Service
     ↓
Strategy Factory
     ↓
Pricing Strategy
     ↓
Repository
     ↓
Database
```

---

# Strategy Pattern

The project uses the Strategy Design Pattern.

Pricing strategies:

- SurgePricingStrategy
- TimeBasedPricingStrategy
- InventoryBasedPricingStrategy

PricingStrategyFactory selects the appropriate strategy at runtime.

---

# Project Structure

```
src
 ├── controller
 │      ProductController
 │      PricingController
 │      PricingRuleController
 │
 ├── service
 │      ProductService
 │      PricingService
 │      PricingRuleService
 │
 ├── serviceImpl
 │      ProductServiceImpl
 │      PricingServiceImpl
 │      PricingRuleServiceImpl
 │
 ├── repository
 │      ProductRepository
 │      PricingRuleRepository
 │      DynamicPriceRepository
 │
 ├── entity
 │      Product
 │      PricingRule
 │      DynamicPrice
 │
 ├── dto
 │      request
 │      response
 │
 ├── strategy
 │      PricingStrategy
 │      SurgePricingStrategy
 │      TimeBasedPricingStrategy
 │      InventoryBasedPricingStrategy
 │
 ├── factory
 │      PricingStrategyFactory
 │
 ├── exception
 │      GlobalExceptionHandler
 │
 ├── config
 │      CacheConfig
 │
 └── enums
        PricingRuleType
```

---

# Database Schema

## Product

| Column | Type |
|---------|------|
| id | BIGINT |
| name | VARCHAR |
| base_price | DECIMAL |

---

## PricingRule

| Column | Type |
|---------|------|
| id | BIGINT |
| type | VARCHAR |
| value | DECIMAL |
| rule_condition | VARCHAR |
| priority | INT |
| version | BIGINT |

---

## DynamicPrice

| Column | Type |
|---------|------|
| id | BIGINT |
| product_id | BIGINT |
| final_price | DECIMAL |
| timestamp | DATETIME |

---

# API Endpoints

## Product APIs

| Method | Endpoint |
|----------|---------------------------|
| POST | /api/products |
| GET | /api/products |
| GET | /api/products/{id} |
| PUT | /api/products/{id} |
| DELETE | /api/products/{id} |

---

## Pricing Rule APIs

| Method | Endpoint |
|----------|--------------------------------|
| POST | /api/pricing-rules |
| GET | /api/pricing-rules |
| GET | /api/pricing-rules/{id} |
| PUT | /api/pricing-rules/{id} |
| DELETE | /api/pricing-rules/{id} |

---

## Pricing API

| Method | Endpoint |
|----------|-------------------------------|
| POST | /api/pricing/calculate |

---

# Sample Request

## Create Product

```json
{
    "name": "iPhone 16 Pro",
    "basePrice": 120000
}
```

---

## Create Pricing Rule

```json
{
    "type": "SURGE",
    "value": 20,
    "condition": "Demand Greater Than 100",
    "priority": 1
}
```

---

## Calculate Dynamic Price

```json
{
    "productId": 1,
    "demand": 150,
    "inventory": 15,
    "hour": 19
}
```

---

# Pricing Calculation Example

Product Base Price

```
120000
```

Applied Rules

- Surge Pricing (+20%)
- Time-Based Pricing (+15%)
- Inventory-Based Pricing (+10%)

Final Price

```
182160
```

---

# Validation

The project uses Hibernate Validator.

Examples:

- Product name cannot be blank.
- Base price must be greater than zero.
- Pricing rule value must be positive.
- Priority cannot be null.
- Product ID must exist.

---

# Exception Handling

Global exception handling is implemented using `@RestControllerAdvice`.

Handled exceptions include:

- Resource Not Found
- Validation Errors
- Illegal Argument Exception
- Runtime Exception

---

# Performance Considerations

- Spring Cache for frequently accessed data.
- Optimistic Locking using `@Version`.
- Strategy Pattern for flexible rule execution.
- Rule execution based on priority.
- Transaction management using `@Transactional`.

---

# Swagger

Open Swagger UI after starting the application:

```
http://localhost:8080/swagger-ui.html
```

or

```
http://localhost:8080/swagger-ui/index.html
```

---

# Running the Project

## Clone Repository

```bash
git clone <repository-url>
```

---

## Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/dynamic_pricing_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## Run

```bash
mvn clean install

mvn spring-boot:run
```
---

# Future Enhancements

- Redis Cache
- Rule Activation/Deactivation
- Rule Expiry
- Product Categories
- Demand Prediction using Machine Learning
- Kafka Event Processing
- Rule Audit Logs
- Docker Deployment

---

# Author

**Sharath H L**

Dynamic Pricing Engine using Spring Boot, Strategy Pattern, Spring Data JPA, MySQL, and Spring Cache.
