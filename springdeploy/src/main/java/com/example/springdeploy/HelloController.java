package com.example.springdeploy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String messaje;
    @GetMapping("/hola")
    public String holaMundo(){

        System.out.println(messaje);
        return "¿Qué tal?";
    }

}
