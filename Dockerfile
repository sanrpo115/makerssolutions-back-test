FROM openjdk:21

WORKDIR /app

COPY target/crud-0.0.1-SNAPSHOT.jar /crud.jar

RUN ls /app

EXPOSE 8080

CMD ["java", "-jar", "/crud.jar"]