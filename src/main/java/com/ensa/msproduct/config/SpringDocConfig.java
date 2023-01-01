package com.ensa.msproduct.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition
@Configuration

public class SpringDocConfig {
    @Bean
    public OpenAPI baseOpenApi(){
        return new OpenAPI().info(new Info().title("Product RestAPI Documentation").version("1.0.0").description("Product RestAPI Endpoints Description"));
    }
}