FROM ubuntu:latest
LABEL authors="Harrisson Dutra"

FROM maven:3-eclipse-temurin:21-jdk-jammy AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /target/api_zap-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]