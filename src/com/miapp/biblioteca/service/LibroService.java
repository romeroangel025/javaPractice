package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;

import java.util.ArrayList;

public class LibroService {
    private ArrayList<Libro> biblioteca;

    //Contructor
    public LibroService(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    //crud
    public void crearLIbro(String titulo, String autor, String ISBN, String genero) {

        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
        biblioteca.add(nuevoLibro);

    }

        public ArrayList<Libro> obtenerTodaBiblioteca() {
            return biblioteca;
        }

    public void actualizarLIbro(String nuevoTitulo, String nuevoAutor, String ISBN, String nuevoGenero) {
        for (Libro libro : biblioteca) {
            if (libro.getISBN().equals(ISBN)) {
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setGenero(nuevoGenero);
            }
        }
    }

    public void eliminarLibro(String ISBN) {
        biblioteca.removeIf(libro -> libro.getISBN().equals(ISBN));

    }


    public Libro libroPorISBN(String ISBN) {
        for (Libro libro : biblioteca) {
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        String tituloMinuscula = titulo.toLowerCase();
        for (Libro libro : biblioteca) {
            if (libro.getTitulo().toLowerCase().equals(tituloMinuscula)) {
                return libro;
            }
        }
        return null;
    }

    public boolean verificarDisponibilidad(Libro libro){
        return libro.isDisponible();
    }

}