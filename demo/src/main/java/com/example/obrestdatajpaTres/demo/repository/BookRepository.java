package com.example.obrestdatajpaTres.demo.repository;


import com.example.obrestdatajpaTres.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
