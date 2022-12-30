FROM maven:3.8.3-openjdk-17 as build-maven
WORKDIR /maven
COPY rabbitmq-microservice-sender/pom.xml .
RUN mvn dependency:go-offline -B
COPY rabbitmq-microservice-sender/src src
RUN mvn install -DskipTests


FROM openjdk:17
COPY --from=build-maven maven/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"] 