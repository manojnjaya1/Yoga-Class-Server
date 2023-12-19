package com.flexmoney.MyYoga.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//Handling CORS configuration
@Configuration
@EnableWebMvc
public class  CorsConfig implements WebMvcConfigurer {

@Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("Content-Type")
            .allowCredentials(true);
}
    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // You can specify a path pattern here
                        .allowedOrigins("*") // Allow requests from this origin
                        .allowedHeaders("Content-Type")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Specify allowed HTTP methods
            }
        };
    }

 }
