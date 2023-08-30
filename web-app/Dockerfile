FROM openjdk:17
WORKDIR /app
COPY /target/web-app-0.0.1-SNAPSHOT.jar web-app.jar
ENTRYPOINT ["java", "-jar", "./web-app.jar"]