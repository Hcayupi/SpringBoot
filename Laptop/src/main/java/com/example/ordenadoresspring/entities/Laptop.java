package com.example.ordenadoresspring.entities;


import java.time.LocalDate;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="laptop")
@ApiModel("Entidad Laptop")
public class Laptop {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincremental de tipo Long")
    private Long id;
    private String modelo;
    private String serie;
    private String marca;
    private String color;
    private LocalDate agnoFabricacion;

    //constructores

    public Laptop(){
    }

    public Laptop(Long id, String modelo, String serie, String marca, String color, LocalDate agnoFabricacion) {
        this.id = id;
        this.modelo = modelo;
        this.serie = serie;
        this.marca = marca;
        this.color = color;
        this.agnoFabricacion = agnoFabricacion;
    }

    //getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getAgnofabricacion() {
        return agnoFabricacion;
    }

    public void setAgnofabricacion(LocalDate agnoFabricacion) {
        this.agnoFabricacion = agnoFabricacion;
    }
}
