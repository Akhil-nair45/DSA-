package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.Service"})
public class Micro2Application {

	public static void main(String[] args) {
		SpringApplication.run(Micro2Application.class, args);
	}

}
