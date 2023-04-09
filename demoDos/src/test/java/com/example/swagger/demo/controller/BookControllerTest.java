package com.example.swagger.demo.controller;

import com.example.swagger.demo.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;
    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Comprobar hola mundo desde controladores SpringBoot")
    @Test
    void hello(){
       ResponseEntity<String> response =  testRestTemplate.getForEntity("/hola", String.class);

      assertEquals(HttpStatus.OK,response.getStatusCode());
      assertEquals(200,response.getStatusCodeValue());
      assertEquals("Hola Mundo que tal vamos!!!!",response.getBody());
    }
    @Test
    void findAll() {
        ResponseEntity<Book[]> response=
        testRestTemplate.getForEntity("/api/books", Book[].class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        List<Book> books= Arrays.asList(response.getBody());
        System.out.println(books.size());

    }

    @Test
    void findOneById() {

        ResponseEntity<Book> response =  testRestTemplate.getForEntity("/api/books/1", Book.class);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                {
                        "title": "Homo Erectus",
                        "author": "Yuval Noah",
                        "pages": 1000,
                        "price": 100,
                        "releaseDate": "2022-08-12",
                        "online": true
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json,header);
        ResponseEntity<Book> response=testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);
        Book result=response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Homo Erectus", result.getTitle());
    }
}