package com.example.dockerDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

//@Component
@Configuration
//@PropertySource("classpath:dev.properties")
//@EnableJpaRepositories(basePackages = "com.example.dockerDemo.repository")
@Profile("!build")

public class DBConfiguration {
	/*@Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
    */
	@Autowired
    private Environment env;
    
	@Bean
	//@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "build", matchIfMissing = false)
    public DataSource dataSource() {
		System.out.println("Inside dataSource");
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		System.out.println("TimeZone===="+TimeZone.getDefault());
		System.out.println("->"+env.getProperty("spring.datasource.url")+"\n"+env.getProperty("spring.datasource.username")+"\n"+env.getProperty("spring.datasource.password"));
       
		if (env.getProperty("spring.datasource.url") == null || env.getProperty("spring.datasource.url").isEmpty()) {
            return null; // Or provide a default data source if needed
        }
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
		
		/*
		return DataSourceBuilder.create()
        		.url(env.getProperty("spring.datasource.url"))
        		.username(env.getProperty("spring.datasource.username"))
        		.password(env.getProperty("spring.datasource.password"))
        		//.url("jdbc:postgresql://192.168.56.1:5432/docker_demo")
        		//.url("jdbc:postgresql://192.168.1.10:5432/docker_demo")
                //.username("postgres")
                //.password("postgres")
                .driverClassName("org.postgresql.Driver")
                .build();
            /*.url(System.getProperty("spring.datasource.url"))
            .username(System.getProperty("spring.datasource.username"))
            .password(System.getProperty("spring.datasource.password"))
            .build();*/ 
		
		
    }
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource) {
		
		 LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(dataSource);
	        em.setPackagesToScan("com.example.dockerDemo.domain"); // Adjust package to your entities
	        
	        /*
	     // Additional JPA properties
	        Map<String, Object> jpaProperties = new HashMap<>();
	        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	        jpaProperties.put("hibernate.show_sql", true);
	        jpaProperties.put("hibernate.format_sql", true);
	        jpaProperties.put("hibernate.use_sql_comments", true);
	        //jpaProperties.put("hibernate.jdbc.batch_size", 50);
	        jpaProperties.put("hibernate.id.new_generator_mappings", false);
	        jpaProperties.put("spring.jpa.hibernate.ddl-auto","update");
	        
	        em.setJpaPropertyMap(jpaProperties);
	        */
	        
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        vendorAdapter.setShowSql(true);
	        vendorAdapter.setGenerateDdl(true);
	        vendorAdapter.setDatabasePlatform(env.getProperty("spring.jpa.properties.hibernate.dialect"));
	        
	        em.setJpaVendorAdapter(vendorAdapter);
	        return em;
        
		/*return builder
                .dataSource(dataSource)
                .packages("com.example.dockerDemo.domain")  // Adjust package to your entity classes
                //.persistenceUnit("yourPersistenceUnit")
                .build();*/
    }
	
	 @Bean
	    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        return transactionManager;
	    }
}

