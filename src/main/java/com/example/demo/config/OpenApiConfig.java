package com.example.demo.config;



	import io.swagger.v3.oas.models.ExternalDocumentation;
	import io.swagger.v3.oas.models.OpenAPI;
	import io.swagger.v3.oas.models.info.Contact;
	import io.swagger.v3.oas.models.info.Info;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;

	@Configuration
	public class OpenApiConfig {

	    @Bean
	    public OpenAPI pricingOpenAPI() {

	        return new OpenAPI().info(new Info().title("Dynamic Pricing Engine API")
	                        .version("1.0")
	                        .description("REST APIs for Dynamic Pricing Engine")
	                        .contact(new Contact()
	                        .name("Sharath")
	                        .email("sharu@gmail.com")))
	                         .externalDocs(new ExternalDocumentation()
	                        .description("Project Documentation"));
	    }
	}


