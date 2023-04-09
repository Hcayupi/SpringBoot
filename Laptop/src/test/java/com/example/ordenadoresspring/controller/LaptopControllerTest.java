package com.example.ordenadoresspring.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import com.example.ordenadoresspring.entities.Laptop;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LaptopControllerTest {
    private TestRestTemplate  testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() throws Exception {
            restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
            testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Test de controladores SpringBoot")
    @Test
    void findAll(){
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());

        if(response.getBody() !=null){
            List<Laptop> laptops = Arrays.asList(response.getBody());
            System.out.println(laptops.size());
        }else{
            System.out.println("Se recibió un nullpointer");
        }

    }


    @Test
    void findOneById() {

        ResponseEntity<Laptop> response =  testRestTemplate.getForEntity("/api/laptop/1", Laptop.class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    void create() {

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(List.of(MediaType.APPLICATION_JSON));

        String json = """
                {
                    "modelo": "NEW0001",
                    "serie": "01",
                    "marca": "Tarro",
                    "color": "Blanco",
                    "agnofabricacion": "2017-02-10"
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json,header);
        ResponseEntity<Laptop> response=testRestTemplate.exchange("/api/laptop", HttpMethod.POST, request, Laptop.class);
        Laptop result=response.getBody();

        if(result !=null){
            assertEquals(1L, result.getId());
            assertEquals("NEW0001", result.getModelo());
        }
        

    }
}
