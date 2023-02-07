package com.example.obspringdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {

    //atributos encapsulados
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacture;
    private String model;
    private Integer year;

    //constructores

    public Coche() {
    }

    public Coche(Long id, String manufacture, String model, Integer year) {
        this.id = id;
        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
    }
    //getter y setter

    public Long getId() {
        return id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

//toString
    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
