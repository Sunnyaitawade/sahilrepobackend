package com.sbadmin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@EnableMongoAuditing
@EnableReactiveMongoRepositories
@SpringBootApplication
public class SbAdminApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbAdminApiApplication.class, args);
	}
	  @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        
	        
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/api/master//**").allowedMethods("PUT", "DELETE","POST","GET");
	            }
	        };
	    }
}
