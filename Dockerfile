FROM openjdk:17-jdk-alpine
ARG JAR_FILE = target/*.jar
EXPOSE 8080
COPY ./target/dockerDemo.jar dockerDemo.jar
ENTRYPOINT ["java","-jar","*/dockerDemo.jar","--spring.config.location=classpath:/application-dev.properties","--spring.profiles.active=dev"]