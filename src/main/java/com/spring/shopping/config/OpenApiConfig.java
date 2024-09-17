package com.spring.shopping.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;



@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Shopping API",
                version = "1.0",
                description = "Simple Shopping Api"
        )
)
public class OpenApiConfig {

}
