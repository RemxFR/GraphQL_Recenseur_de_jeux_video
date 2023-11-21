# syntax=docker/dockerfile:1

FROM eclipse-temurin:11-jdk-jammy

WORKDIR /games

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=mysql"]