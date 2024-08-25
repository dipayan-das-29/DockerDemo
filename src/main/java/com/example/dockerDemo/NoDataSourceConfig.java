package com.example.dockerDemo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("build")
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class NoDataSourceConfig {

}
