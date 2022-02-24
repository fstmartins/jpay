FROM openjdk:11

ADD jpay.db jpay.db
ADD target/jpay-0.0.1-SNAPSHOT.jar service.jar
EXPOSE 8080
ENTRYPOINT ["java", \
            "-Dspring.profiles.active=live", \
            "-jar", \
            "service.jar"]
