FROM maven:3.8-amazoncorretto-17  AS dependencies
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

FROM maven:3.8-amazoncorretto-17 AS builder
WORKDIR /app
COPY --from=dependencies /root/.m2 /root/.m2
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17.0.0-alpine
WORKDIR /app
COPY --from=builder /app/target/challenge-foro-hub-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
