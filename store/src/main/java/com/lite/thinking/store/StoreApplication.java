package com.lite.thinking.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lite.thinking.store.dto.*;


@SpringBootApplication
@ComponentScan(basePackages = "com.lite.thinking.store")
@EnableWebMvc
public class StoreApplication implements WebMvcConfigurer  {

	public static void main(String[] args) {        
		SpringApplication.run(StoreApplication.class, args);
	}
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") 
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}
