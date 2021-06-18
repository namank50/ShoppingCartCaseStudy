package com.casestudy.Admin.SwaggerConfig;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    private ApiInfo appInformation() {
		return new ApiInfo(
				"Swagger API For Dealer Micro",
				"Public API",
				"Using Spring Boot Version",
				"2.3.11", 
				new Contact("Naman Kapoor","namank50@gmail.com","9720531773"), 
				"Dealer",
				"Swagger",
				Collections.emptyList());
	}
}                