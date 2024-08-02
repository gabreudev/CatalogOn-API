# Etapa de build
FROM ubuntu:latest AS build

RUN apt-get update \
    && apt-get install -y openjdk-17-jdk maven

WORKDIR /app
COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/target/CatalogOn-0.0.1-SNAPSHOT.jar /app/app.jar
COPY wait-for-it.sh /app/wait-for-it.sh

RUN chmod +x /app/wait-for-it.sh

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
EXPOSE 8080
