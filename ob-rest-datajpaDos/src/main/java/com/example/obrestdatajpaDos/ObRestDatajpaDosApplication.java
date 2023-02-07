package com.example.obrestdatajpaDos;

import com.example.obrestdatajpaDos.entities.Book;
import com.example.obrestdatajpaDos.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ObRestDatajpaDosApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaDosApplication.class, args);

		BookRepository repository = context.getBean(BookRepository.class);


		//CRUD
		//Crear libro
		Book book = new Book(null, "Homo sapiens", "Yuval Noah", 450,29.99, LocalDate.of(2022,12,1), true);
		Book bookDos = new Book(null, "Homo Deus", "Yuval Noah", 200,29.99, LocalDate.of(2022,8,12), true);
		System.out.println("Num libros en base de datos:" + repository.findAll().size());
		//Almacenar un libro
		repository.save(book);
		repository.save(bookDos);
		//Recuperar todos los libros
		System.out.println("Num libros en base de datos:" +repository.findAll().size());
		List<Book> listaLibros = repository.findAll();

		for (Book libro:listaLibros) {

			System.out.println(libro.getAuthor());
		}

		//Borrar un libro
		//repository.deleteById(1L);
		System.out.println("Num libros en base de datos:" +repository.findAll().size());
	}

}
