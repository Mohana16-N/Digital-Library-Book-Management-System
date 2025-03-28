# Digital Library Book Management System

## Overview
The **Digital Library Book Management System** is a Spring Boot application that provides a backend system for managing a digital library. It uses **MySQL** as the database and is containerized using **Docker**.

## Features
- Book management (add, update, delete, search)
- MySQL database integration
- RESTful API built with Spring Boot
- Docker containerization with Docker Compose

## Technologies Used
- **Spring Boot (Java 17)**
- **MySQL 8.0**
- **Docker & Docker Compose**
- **Hibernate (JPA)**
- **Maven**

## Project Structure
```
Digital-Library-Book-Management-System/
│── src/                      # Source code (Controllers, Services, Repositories, Models)
│── target/                   # Compiled JAR file
│── Dockerfile                # Dockerfile for containerizing the application
│── docker-compose.yaml       # Docker Compose for MySQL and the app
│── application.properties    # Spring Boot application properties
│── mvnw, mvnw.cmd            # Maven wrapper for Windows/Linux
│── pom.xml                   # Maven dependencies
│── README.md                 # Project documentation
```

---
## Installation & Setup
### Prerequisites
Ensure you have the following installed:
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Clone the Repository
```sh
git clone https://github.com/your-username/Digital-Library-Book-Management-System.git
cd Digital-Library-Book-Management-System
```

### Build the Project
If running locally (without Docker):
```sh
mvn clean package
```

This generates a JAR file inside the `target/` directory.

---
## Running with Docker
### 1️⃣ Build & Start Containers
```sh
docker-compose up --build -d
```
### 2️⃣ Check Running Containers
```sh
docker ps
```
Ensure `digital_library_app` and `digital_library_db` are running.

### 3️⃣ View Logs
```sh
docker logs digital_library_app
```

### 4️⃣ Access the Application
Open a browser and go to:
```
http://localhost:8080
```

---
## Configuration
### `application.properties`
```properties
spring.application.name=Digital-Library-Book-Management-System
server.port=8080
spring.datasource.url=jdbc:mysql://mysql:3306/digital_library
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

---
## Deployment
To deploy on a cloud-based Docker environment (like AWS, GCP, or Azure):
1. **Build the Docker image**
   ```sh
   docker build -t digital-library-app .
   ```
2. **Push to Docker Hub**
   ```sh
   docker tag digital-library-app your-dockerhub-username/digital-library-app
   docker push your-dockerhub-username/digital-library-app
   ```
3. **Run on a cloud server**
   ```sh
   docker run -d -p 8080:8080 your-dockerhub-username/digital-library-app
   ```

---
## Stopping & Restarting
- Stop all containers:
  ```sh
  docker-compose down
  ```
- Restart after making changes:
  ```sh
  docker-compose up --build -d
  ```

---
## Contributing
1. Fork the repository.
2. Create a new branch (`feature/your-feature`).
3. Commit your changes.
4. Push to your fork and submit a pull request.

---
## License
This project is licensed under the **MIT License**.

