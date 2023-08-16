FROM openjdk:17
LABEL authors="martinmichalek"

ADD target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
