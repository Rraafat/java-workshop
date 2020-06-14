FROM openjdk:8-jdk-alpine
RUN -d -p 5432:5432 ghusta/postgres-world-db:2.4
ADD target/java-workshop.jar java-workshop.jar
ENTRYPOINT ["java","-jar","java-workshop.jar"]


