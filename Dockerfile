FROM openjdk:17-jdk-alpine
#ARG JAR_FILE=target/*.jar
WORKDIR /app
COPY target/dockerDemo.jar /app/dockerDemo.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","/app/dockerDemo.jar","--spring.config.location=classpath:/application-dev.properties","--spring.profiles.active=dev"]