FROM openjdk:17
COPY target/governament-api-0.0.1-SNAPSHOT.jar /app/governament-api.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "governament-api.jar"]
EXPOSE 8080