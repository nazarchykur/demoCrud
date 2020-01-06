package com.example.demoCRUD_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCrudApplication {

    // no need service and controller
	// only add dependency <spring-boot-starter-data-rest> to our POM.XML
	// and we have all functionality for free
	// all crud operations are works fine

	// all we need to remember that we have ENTITY -> Employee
	// to our URI we add name of this entity which starts w/ small caps
	// and add 's' to end =>
	// fot our CRUD we use /employees
	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}



}
