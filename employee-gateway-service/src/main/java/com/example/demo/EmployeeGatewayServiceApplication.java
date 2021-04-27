package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableZuulProxy
@SpringBootApplication
public class EmployeeGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeGatewayServiceApplication.class, args);
	}

}
