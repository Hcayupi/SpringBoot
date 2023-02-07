package com.example.obspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(ObSpringdatajpaApplication.class, args);
		CocheRepository repository = context.getBean(CocheRepository.class);

		System.out.println("find");
		//System.out.println("El  número de coches en la BD es: " +repository.count());

		//Crear y almacenar un coche en BD

		//Coche toyota = new Coche(null, "Toyota", "Prius", 2010);
		//repository.save(toyota);
	}

}
