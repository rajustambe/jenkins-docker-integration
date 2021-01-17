FROM adoptopenjdk/openjdk8:x86_64-alpine-jre8u232-b09
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
