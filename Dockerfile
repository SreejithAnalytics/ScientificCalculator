# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file and install dependencies (optional)
COPY pom.xml ./
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

# Copy the project files into the container
COPY . . 

# Build the application using Maven
RUN mvn clean package

# Expose the application port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "target/ScientificCalculator-0.0.1-SNAPSHOT.jar"]
