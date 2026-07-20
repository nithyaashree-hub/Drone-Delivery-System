# 🚁 Drone Delivery System

## 📖 Project Overview

The Drone Delivery System is a microservices-based Spring Boot application developed as a Capstone Project. It automates last-mile package delivery using drones by assigning available drones, validating delivery requests, calculating routes, monitoring battery levels, tracking deliveries, and updating package status.

---

## 🏗️ Microservices

### 🚁 Drone Service
- Register drones
- Update drone details
- Track battery level
- Check payload capacity
- Check drone availability

### 📦 Package Service
- Register packages
- Validate package weight
- Update package status
- Store package details

### 🛣️ Route Service
- Calculate delivery route
- Calculate distance
- Store weather condition
- Validate delivery route

### 🚚 Delivery Service
- Register delivery
- Assign drone using RestTemplate
- Check battery before assignment
- Reject packages exceeding payload
- Reject delivery during bad weather
- Update package status
- Store delivery history

### 🌐 API Gateway
- Routes all client requests to the appropriate microservice.

---

# ⚙️ Technologies Used

- Java 17
- Spring Boot 3.5.3
- Spring Data JPA
- Hibernate
- H2 Database
- Spring Cloud Gateway
- RestTemplate
- Maven
- IntelliJ IDEA
- Postman
- Git & GitHub

---

# ✅ Functional Requirements Implemented

✔ Register drones with unique Drone ID

✔ Register packages

✔ Route calculation

✔ Drone assignment using RestTemplate

✔ Battery validation (≥30%)

✔ Payload validation

✔ Weather validation (CLEAR)

✔ Package Status

- CREATED
- ASSIGNED
- IN_TRANSIT
- DELIVERED
- FAILED

✔ Delivery History

✔ API Gateway

---

# ⚠️ Validations

- Weight > 0
- Battery ≥ 30%
- Weather = CLEAR
- Drone must be available
- Package weight ≤ Drone payload
- Unique Drone ID

---

# 🚨 Custom Exceptions

- DroneNotAvailableException
- LowBatteryException
- PackageNotFoundException
- RouteNotFoundException
- BadWeatherException
- MethodArgumentNotValidException

---

# 📂 Project Structure

```
Drone-Delivery-System
│
├── DroneService
├── PackageService
├── RouteService
├── DeliveryService
├── ApiGateway
└── README.md
```

---

# 📸 Screenshots

## Project Structure

![Project Structure](Screenshots/project-structure.png)

---

## Drone Service APIs

![Drone Service](Screenshots/drone-service.png)

---

## Package Service APIs

![Package Service](Screenshots/package-service.png)

---

## Route Service APIs

![Route Service](Screenshots/route-service.png)

---

## Delivery Service APIs

![Delivery Service](Screenshots/delivery-service.png)

---

## API Gateway

![API Gateway](Screenshots/api-gateway.png)

---

## Postman Testing

![Postman](Screenshots/postman-testing.png)

---

## H2 Database

![H2 Database](Screenshots/h2-database.png)

---

## Console Logs

![Console Logs](Screenshots/console-logs.png)

---

# 👩‍💻 Author

**Nithyaa Shree**

B.Tech – Information Technology

Capstone Project – Drone Delivery System
