package com.WebApp.WebApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dni")
    private String dni;
    @Column(name = "password")
    private String password;

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
