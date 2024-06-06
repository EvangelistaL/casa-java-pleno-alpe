FROM openjdk:17
COPY target/charging-api-0.0.1-SNAPSHOT.jar /app/charging-api.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "charging-api.jar"]
EXPOSE 8080