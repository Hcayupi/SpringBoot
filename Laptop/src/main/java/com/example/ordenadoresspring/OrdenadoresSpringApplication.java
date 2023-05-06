package com.example.ordenadoresspring;

import com.example.ordenadoresspring.entities.Laptop;
import com.example.ordenadoresspring.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class OrdenadoresSpringApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OrdenadoresSpringApplication.class, args);

		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop = new Laptop(null, "L4015","NN", "Compaq", "blanco", LocalDate.of(2022,12,1));
		Laptop laptop2 = new Laptop(null, "L3423","NN", "Samsung", "Negro grafito", LocalDate.of(2019,4,20));
		Laptop laptop3 = new Laptop(null, "L3423","NN", "Samsung", "Negro grafito", LocalDate.of(2019,4,20));
		Laptop laptop4 = new Laptop(null, "L30023","12", "Mac", "gris", LocalDate.of(2017,2,10));

		repository.save(laptop);
		repository.save(laptop2);
		repository.save(laptop3);
		repository.save(laptop4);

		System.out.println("Num laptops en base de datos: " +repository.findAll().size());
	}

}
