# Use a base image with Maven for building and Java for running
FROM maven:3.9.5-openjdk-17 AS builder

# Set the working directory
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the JAR file
RUN ./mvnw clean package -DskipTests

# Use a lightweight Java image for the final container
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/shop-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
