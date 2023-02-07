package com.example.obrestdatajpaDos.controller;

import com.example.obrestdatajpaDos.entities.Book;
import com.example.obrestdatajpaDos.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    //atributos
    private final BookRepository bookRepository;
    //constructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //CRUD sobre la entidad Book

    //Buscar todos los libros

    /**
     * http://localhost:8080/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        //recuperar yu devolver los libros de base de datos
        return bookRepository.findAll();
    }

    //Buscar un solo libro en caso de datos segun su id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){

        Optional<Book> bookOpt = bookRepository.findById(id);

        if(bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();

        //return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**public Book findOneById(@PathVariable Long id){
       Optional<Book> bookOpt =  bookRepository.findById(id);
        //Opción 1
      // if(bookOpt.isPresent()){
      //     return bookOpt.get();
        //  }else {
      //     return null;
     //  }

       //Opción 2
        return bookOpt.orElse(null);
    }*/

    //Crear un nuevo libro en base de datos

    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
       return  bookRepository.save(book);
    }
    //actualizar un libro existente en base de datos

    //Borrar un libro en base de datos
}
