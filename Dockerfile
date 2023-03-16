# Set the base image for the first stage of the build
FROM maven:3.8.1-openjdk-17-slim AS build

# Set the working directory for the first stage of the build
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml .

# Download all the project dependencies and cache them locally
RUN mvn dependency:go-offline

# Copy the source code to the working directory
COPY src ./src

# Build the project and package it into a JAR file, skipping tests
RUN mvn clean package -DskipTests

# Set the base image for the second stage of the build
FROM openjdk:17-jdk-slim

# Copy the JAR file from the first stage to the second stage
COPY --from=build /app/target/*.jar /app.jar

# Expose port 3000 to the outside world
EXPOSE 3000

# Set the entrypoint for the container to run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]
