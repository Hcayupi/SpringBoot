package org.javanuit;

public class GestorFacturas {

    //1. atributtos
    Calculadora calculadora;
    String nombre;

    //2. contructores
    public GestorFacturas(Calculadora calculadora, String nombre) {
        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora = calculadora;
        this.nombre = nombre;
    }
    //3.Metodos


}
