package com.akash.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service Rest Api's",
				description = "Organization Service Rest Api's Documentation",
				version = "v1.0",
				contact = @Contact(
						name= "Akash Gupta",
						email = "akashgupta8993@gmail.com",
						url = "https://www.linkedin.com/in/akash-gupta-4a421716a?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"

				),
				license = @License(
						name = "Apache 2.0",
						url ="https://www.linkedin.com/in/akash-gupta-4a421716a?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"

				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization Service Documentation",
				url=""

		)
)
@SpringBootApplication
public class OrganizationServiceApplication {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
