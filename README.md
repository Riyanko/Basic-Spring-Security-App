
# Spring Security 6 Application with JWT Authentication and Authorization

This project is a sample implementation of JWT-based authentication and authorization using **Spring Security 6**. The application showcases secure endpoints where access is controlled by JWT tokens.

## Features
- **Spring Security 6 Integration**: Leverages new features introduced in Spring Security 6.
- **JWT Authentication**: Issue and validate JWT tokens for user login.
- **Role-based Access Control**: Protect API routes based on user roles (e.g., ADMIN, USER).
- **Stateless Authentication**: Fully stateless, with no session stored on the server.
- **Custom JWT Filter**: Process requests through a custom filter to extract and validate JWT tokens.
- **Password Hashing**: Secure password storage using BCrypt.
- **Exception Handling**: Global exception handling for authentication and authorization failures.

## Technologies Used
- Java 17
- Spring Boot 3.x
- Spring Security 6
- Spring Data JPA
- JWT (JSON Web Token)

## Prerequisites
- JDK 17+
- Maven 3.x
