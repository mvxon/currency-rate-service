FROM openjdk:17-oracle
EXPOSE 8080
ADD target/*.jar currency-rate-service.jar
ENTRYPOINT ["java", "-jar", "/currency-rate-service.jar"]