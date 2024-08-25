package com.example.dockerDemo;

//import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.dockerDemo.repository")
@EntityScan(basePackages = "com.example.dockerDemo.domain")
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class DockerDemoApplication {

	/*
    @PostConstruct
    public void init() {
        // Setting Spring Boot default timezone globally to Asia/Kolkata
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
    }*/
	public static void main(String[] args) {
		SpringApplication.run(DockerDemoApplication.class, args);
	}

}
