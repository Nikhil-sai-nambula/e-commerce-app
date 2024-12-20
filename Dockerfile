# Use a base image with Java 17 (required by your application)
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY . .

# Build the project and package the application
# This requires Maven to be installed on your local machine
# If you have already built the JAR file, copy the JAR directly instead of building here
RUN ./mvnw clean package -DskipTests

# Copy the packaged JAR file to the container
# Replace 'shop-0.0.1-SNAPSHOT.jar' with the actual name of the built JAR file
COPY target/shop-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
