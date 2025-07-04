# Use Eclipse Temurin base image for Java 21
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY DEMO/mvnw DEMO/mvnw
COPY DEMO/mvnw.cmd DEMO/mvnw.cmd
COPY DEMO/pom.xml DEMO/pom.xml
COPY DEMO/.mvn DEMO/.mvn

# Copy the source code
COPY DEMO/src DEMO/src

# Make Maven wrapper executable
RUN chmod +x DEMO/mvnw

# Build the application
RUN ./DEMO/mvnw -f DEMO/pom.xml clean package -DskipTests

# Run the application
CMD ["java", "-jar", "DEMO/target/demo-0.0.1-SNAPSHOT.jar"]