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

## Drone Service 

<img width="1920" height="1080" alt="Screenshot (432)" src="https://github.com/user-attachments/assets/876d67af-e17f-4457-909f-57ca6a66ebe6" />

<img width="1920" height="1080" alt="Screenshot (436)" src="https://github.com/user-attachments/assets/4fb7ecb3-861a-4d26-a6e8-7b7aba1d7f4f" />

## Package Service 

<img width="1920" height="1080" alt="Screenshot (435)" src="https://github.com/user-attachments/assets/d6fd3e29-55a8-40e5-a148-8726848f9922" />

<img width="1920" height="1080" alt="Screenshot (434)" src="https://github.com/user-attachments/assets/de0af3b0-90bc-41c4-b998-92b7b75e0ee8" />

## Route Service 

<img width="1920" height="1080" alt="Screenshot (437)" src="https://github.com/user-attachments/assets/17da4d73-0166-41c4-a1f8-daebbf4eb272" />

<img width="1920" height="1080" alt="Screenshot (438)" src="https://github.com/user-attachments/assets/6bace624-88e8-4a43-9a10-43bc6de3970f" />

## Delivery Service 

<img width="1920" height="1080" alt="Screenshot (439)" src="https://github.com/user-attachments/assets/ddfed0a9-eaa9-42ad-869d-b9e5dc4b33c7" />

<img width="1920" height="1080" alt="Screenshot (441)" src="https://github.com/user-attachments/assets/b4782e12-6825-400c-b05f-1cad8bc6c481" />

## API Gateway

<img width="1920" height="1080" alt="Screenshot (447)" src="https://github.com/user-attachments/assets/e8958c13-987b-4e87-98c8-a5cae104b954" />

## H2 Database

<img width="1920" height="1080" alt="Screenshot (442)" src="https://github.com/user-attachments/assets/edad0759-c8eb-4f22-b4ae-2f0a7f41adb1" />

<img width="1920" height="1080" alt="Screenshot (443)" src="https://github.com/user-attachments/assets/1b3eff92-ed6d-4b38-97af-8e7e8b74cf07" />

<img width="1920" height="1080" alt="Screenshot (444)" src="https://github.com/user-attachments/assets/9c1a5a5f-4e52-41bb-ba72-f6f22fb21368" />

<img width="1920" height="1080" alt="Screenshot (445)" src="https://github.com/user-attachments/assets/c30dd003-0ec3-4758-8968-6096f7828115" />

<img width="1920" height="1080" alt="Screenshot (446)" src="https://github.com/user-attachments/assets/95598328-511c-498c-840f-8da9d455f826" />

# 👩‍💻 Author

**Nithyaa Shree T**

B.Tech – Information Technology

Capstone Project – Drone Delivery System
