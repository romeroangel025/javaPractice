package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;

public class UsuarioService {

    private ArrayList<Usuario> listaUsuarios;

    public UsuarioService(ArrayList<Usuario> usuarios) {
        listaUsuarios = new ArrayList<>();
    }

    public void crearUsuario(String nombre, String id) {
        Usuario nuevoUsuario = new Usuario(nombre, id);
        listaUsuarios.add(nuevoUsuario);
    }

    public ArrayList<Usuario> obtenerTodosLosUsuarios() {
        return listaUsuarios;
    }

    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public void actualizarUsuario(String nombre, String id, String nuevoNombre, String nuevoId) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {
            usuario.setNombre(nuevoNombre);
            usuario.setId(nuevoId);
        }
    }

    public void eliminarUsuario(String id) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {
            listaUsuarios.remove(usuario);
        }
    }

    public void prestarLibro(Usuario usuario, Libro libro) {
        if (libro.isDisponible()) {
            usuario.getLibrosPrestados().add(libro);
            libro.setDisponible(false);

        } else {
            System.out.println("El libro no esta disponible");
        }


    }

    public void devolverLibro(Usuario usuario, Libro libro) {
        if (usuario.getLibrosPrestados().contains(libro)) {
            usuario.getLibrosPrestados().remove(libro);
            libro.setDisponible(true);
        } else {
            System.out.println("El libro no corresponde al usuario");
        }

    }


}
