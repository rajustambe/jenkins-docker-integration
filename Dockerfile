FROM openjdk:8
EXPOSE 8081
ADD target/test-controller-example-0.0.1-SNAPSHOT.jar jenkins-docker-integration.jar
ENTRYPOINT ["java","-jar","/jenkins-docker-integration.jar"]
