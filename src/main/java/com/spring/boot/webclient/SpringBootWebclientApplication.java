package com.spring.boot.webclient;

import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebclientApplication {

	
	public static void main(String[] args) throws URISyntaxException 
	{
		System.out.println("main called");
		SpringApplication.run(SpringBootWebclientApplication.class, args);
		WebClientAPIUsingExchangeMethod webClientAPI = new WebClientAPIUsingExchangeMethod();
	    webClientAPI.getAllEmployees()
	    .thenMany(webClientAPI.saveEmployee())
	    .thenMany(webClientAPI.getAllEmployees())
	    .thenMany(webClientAPI.updateEmployee())
	    .thenMany(webClientAPI.getAllEmployees())
	    .thenMany(webClientAPI.deleteEmployee("5"))
	    .thenMany(webClientAPI.getAllEmployees())
	    .subscribe();
	
	}

}
