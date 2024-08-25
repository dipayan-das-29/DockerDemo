FROM openjdk:8
EXPOSE 8080
ADD target/dockerDemo.jar dockerDemo.jar
ENTRYPOINT ["java","-jar","dockerDemo.jar"]