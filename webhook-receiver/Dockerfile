FROM openjdk:17
COPY target/webhook-receiver-0.0.1-SNAPSHOT.jar /app/webhook-receiver.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "webhook-receiver.jar"]
EXPOSE 8080