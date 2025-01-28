# Use an official Java runtime as the base image (Amazon Corretto 21)
FROM amazoncorretto:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container (update the path to your JAR file)
COPY target/PetClinic-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port on which your Spring Boot app will run (default is 8080)
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
