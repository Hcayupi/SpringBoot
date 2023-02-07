package com.example.ordenadoresspring.controller;

import com.example.ordenadoresspring.entities.Laptop;
import com.example.ordenadoresspring.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    //atributos
    private final LaptopRepository laptopRepository;

    //constructores
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //Lista de laptops
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    //Guardar Laptop

    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return laptopRepository.save(laptop);
    }
}
