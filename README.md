# Overview
This project showcases a microservices-based architecture using Spring Boot, Spring Cloud, and Netflix Eureka for service discovery. The Eureka Discovery Server allows all microservices to register and communicate with each other, while the Gateway acts as a unified entry point for external access to these services.

## Architecture
(Include an architecture diagram if available)

The system consists of the following components:
* Customer Service: Handles Customer details.
* Product Service: Manages product details.
* Billing Service: Handles billing of product-customer.
* Eureka Discovery Server: Service registry for microservices.
* Gateway: Routes external requests to the appropriate microservice.
  
## Microservices :
  
### Customer Service :
The Client Service is responsible for creating, viewing, and managing customer.
-> Port: 8081

### Product Service
The Product Service manages the products catalog for the application.
-> Port: 8082
![image](https://github.com/user-attachments/assets/e7442be7-45bc-401c-add1-38fe4b03d38c)

### Billing Service
The Payment Service handles billing process of product-customer.
-> Port: 8084
Technologies: Spring Boot, PostgreSQL
Key Endpoint:
![image](https://github.com/user-attachments/assets/a5eff13c-a004-4521-b1fd-595bbfcdc2bd)


### Eureka Discovery Server
The Eureka Discovery Server manages service registration and discovery, enabling microservices to find and communicate with each other without hardcoding IP addresses.
![image](https://github.com/user-attachments/assets/a91abcd5-0bc0-49a8-bc2a-29d311ec2e1b)

-> Port: 8761
Technologies: Spring Boot, Spring Cloud Netflix Eureka
Key Endpoint:
GET /eureka: Eureka dashboard for monitoring services

### Gateway
The Gateway acts as a reverse proxy, routing requests to the appropriate microservices. It also performs load balancing and security checks.

-> Port: 8080
Technologies: Spring Cloud Gateway, Spring Security
Key Route:
![image](https://github.com/user-attachments/assets/fb0dbd3a-d0a8-4788-9b6f-4e936114be9d)
