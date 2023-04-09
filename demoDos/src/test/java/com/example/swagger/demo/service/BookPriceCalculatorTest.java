package com.example.swagger.demo.service;

import com.example.swagger.demo.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatorPrice() {
        //Configuraciòn de la prueba
        Book book = new Book(1L, "El señor de los anillos", "Authir", 1000,49.99, LocalDate.now(), true);
        BookPriceCalculator calculator=new BookPriceCalculator();

        //Se ejecuta el comportamiento a testear
        double price = calculator.calculatorPrice(book);
        System.out.println(price);
        //Comprobaciones aserciones
        assertTrue(price>0);
        assertEquals(57.980000000000004, price);
    }
}