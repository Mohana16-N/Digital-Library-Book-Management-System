# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY target/Digital-Library-Book-Management-System-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Grant execute permission
RUN chmod +x app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
