package com.spring.boot.webclient;

import java.net.URISyntaxException;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebClientAPI 
{
	//create web client instance
	
//	private WebClient webClient = WebClient.create()
	private WebClient webClient = WebClient.create("http://localhost:8080/v1");
	
		
	//prepare request
	
	public Flux<Employee> getAllEmployees() throws URISyntaxException
	{
		System.out.println("Inside getAllEmployees() ");
		return webClient.get()
		.uri("/employees")
//		.uri(new URI("/employees"))
		.retrieve()
		.bodyToFlux(Employee.class)
		.doOnNext(it -> System.out.println("Inside getAllEmployees "+it));
	}
	
	public Mono<Employee> saveEmployee() throws URISyntaxException
	{
		System.out.println("Inside getAllEmployees() ");
//		Employee emp = new Employee("5","katrina","PLM");
		return webClient.post()
		.uri("/employees")
		.body(BodyInserters.fromValue(new Employee("5","katrina","PLM")))
		.retrieve()
		.bodyToMono(Employee.class)
		.doOnNext(it -> System.out.println("Inside saveEmployee "+it));
	}
	
	public Mono<Employee> updateEmployee() throws URISyntaxException
	{
		System.out.println("Inside getAllEmployees() ");
//		Employee emp = new Employee("5","katrina","PLM");
		return webClient.put()
		.uri("/employees/update")
		.body(BodyInserters.fromValue(new Employee("5","katrina","IT")))
		.retrieve()
		.bodyToMono(Employee.class)
		.doOnNext(it -> System.out.println("Inside updateEmployee "+it));
	}
	
	public Mono<Employee> deleteEmployee(String id) throws URISyntaxException
	{
		System.out.println("Inside getAllEmployees() ");
//		Employee emp = new Employee("5","katrina","PLM");
		return webClient.delete()
		.uri("/employees/{id}",id)
		.retrieve()
		.bodyToMono(Employee.class)
		.doOnSuccess(it -> System.out.println("Inside deleteEmployee "+it));
	}
	

}
