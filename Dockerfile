FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY build/libs/api_zap-0.0.1.jar /app/api_zap-0.0.1.jar
EXPOSE 8080
CMD ["java", "-jar", "api_zap-0.0.1.jar"]
