package com.WebApp.WebApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "domicilio")
public class Domicilio {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
        @Column(name = "direccion")
    private String direccion;

    @ManyToOne(optional = false) //Indica que tiene que sí o sí tener una provincia
    @JoinColumn(name = "fk_provincia")
    private Provincia provincia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
