FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY target/demo-0.0.1-SNAPSHOT.jar labapp.jar
ENTRYPOINT ["java","-jar","labapp.jar"]