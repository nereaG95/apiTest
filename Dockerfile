FROM openjdk:11 as build

WORKDIR /opt/app

ARG JAR_FILE=target/api-0.0.1-SNAPSHOT.jar

# cp spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} api-0.0.1-SNAPSHOT.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","api-0.0.1-SNAPSHOT.jar"]