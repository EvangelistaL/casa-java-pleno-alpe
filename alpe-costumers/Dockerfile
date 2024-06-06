FROM openjdk:17
COPY target/alpe-costumers-0.0.1-SNAPSHOT.jar /app/alpe-costumers.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "alpe-costumers.jar"]
EXPOSE 8080