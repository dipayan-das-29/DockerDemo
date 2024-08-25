FROM openjdk:8
EXPOSE 8080
ADD target/dockerDemo.jar dockerDemo.jar
ENTRYPOINT ["java","-jar","dockerDemo.jar","--spring.config.location=classpath:/application-dev.properties","--spring.profiles.active=dev"]