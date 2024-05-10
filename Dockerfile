FROM openjdk:22-ea-20-jdk-oracle

LABEL authors="MIKHAIL"

EXPOSE 8080

ADD target/Authorization-0.0.1-SNAPSHOT.jar myApp.jar

CMD ["java", "-jar", "myApp.jar"]