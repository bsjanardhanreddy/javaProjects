package com.jsp.exp.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootProjectExp4Application 
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringbootProjectExp4Application.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() 
	{
		return new RestTemplate();
	}
	
	@Bean("getRestTemplateobj")
	public RestTemplate getRestTemplateObject() 
	{
		return new RestTemplate();
	}
	

}
