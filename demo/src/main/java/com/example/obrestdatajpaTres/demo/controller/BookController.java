package com.example.obrestdatajpaTres.demo.controller;

import com.example.obrestdatajpaTres.demo.entities.Book;
import com.example.obrestdatajpaTres.demo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final Logger log = LoggerFactory.getLogger(BookController.class);

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
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        //guardar el libro recibido por parámetros en la base de datos
        if(book.getId() != null){
            log.warn("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
       return  ResponseEntity.ok(result);
    }
    //actualizar un libro existente en base de datos

    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if(book.getId() == null){//Si no tiene id queire decir que si es una creación
            log.warn("Trying to update a non existent book.-");

            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())){
            log.warn("trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }
    //Borrar un libro en base de datos

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete( @PathVariable Long id){

        if(!bookRepository.existsById(id)){
            log.warn("trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

            bookRepository.deleteById(id);


        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("REST Request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
