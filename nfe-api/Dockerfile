FROM openjdk:17
COPY target/nfe-api-0.0.1-SNAPSHOT.jar /app/nfe-api.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "nfe-api.jar"]
EXPOSE 8080