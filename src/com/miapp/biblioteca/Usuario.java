package com.miapp.biblioteca;

import java.util.ArrayList;
public class Usuario{

    private String nombre;

    private String id;

    private ArrayList<Libro> librosPrestados;


    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id=id;
        this.librosPrestados = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", librosPrestados=" + librosPrestados.toString() +
                '}';
    }


//getter y setter

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }
}





