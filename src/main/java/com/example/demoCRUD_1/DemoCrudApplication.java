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

	// if we need specify the name we need add @RepositoryRestResource(path="nameRepo")
	// at our interface repository which one extends JpaRepository

	// in application.properties file we can define our Spring Data REST props
	// #spring.data.rest.base-path=/our-api     for  base-path
	// #spring.data.rest.default-page-size=10    for pagination => size el per page
	// and other...

	// for sorting in URI use ?sort=lastName,desc
	// sorting by lastName by descending
	// we can sort by any name of field our ENTITY

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}



}
