# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# Preparing the tomcat for deployment
FROM tomcat:9.0.64-jre11-openjdk-slim-bullseye

# Add SQLite db
COPY jpay.db /opt/app/jpay.db

# Refer to Maven build -> finalName
#ARG JAR_FILE=target/jpay-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=target/spring-boot-web.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
