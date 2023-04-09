package com.example.ordenadoresspring.controller;

import com.example.ordenadoresspring.entities.Laptop;
import com.example.ordenadoresspring.repository.LaptopRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //atributos
    private final LaptopRepository laptopRepository;

    //constructores
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //CRUD sobre la entidad Laptop

    //Lista de laptops
    /**
     * http://localhost:8080/api/laptops
     * @return
     */
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }
    //Guardar Laptop
    /**
     * http://localhost:8080/api/laptop
     * @param laptop
     * @param headers
     * @return
     */
    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return laptopRepository.save(laptop);
    }

    //Buscar un solo laptop por su id
    
    @GetMapping("/api/laptop/{id}")
    @ApiOperation("Buscar un laptop por su clave primaria")
    public ResponseEntity<Laptop> findLaptopById(@ApiParam("Clave primaria tipo Long")@PathVariable Long id){
        Optional <Laptop> laptop = laptopRepository.findById(id);

        if(laptop.isPresent())
            return ResponseEntity.ok(laptop.get());
        else    
            return ResponseEntity.notFound().build();
    }
    //Actualizar un laptop existente en base de datos
    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId()==null){
            log.warn("Trying to update a non existent laptop.-");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to update a non existent laptop.-");
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //Borrar un libro en base de datos en la

    @DeleteMapping("/api/laptop/{id}")
    @ApiIgnore
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //Eliminar todos los datos de la base de datos 

    @DeleteMapping("/api/laptops/delAll")
    public ResponseEntity<Laptop> deleteAll(){
    
        log.info("Deleting all");

        laptopRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
