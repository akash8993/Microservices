package com.akash.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service Rest Api's",
				description = "Employee Service Rest Api's Documentation",
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
				description = "Employee Service Documentation",
				url=""

		)
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

//	@Bean
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}
//
	/*For Using WebCLient*/
//	@Bean
//	public WebClient webClient()
//	{
//		return  WebClient.builder().build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
