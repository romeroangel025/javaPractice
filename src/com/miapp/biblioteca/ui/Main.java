package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.UsuarioService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Libro> biblioteca = new ArrayList<>();
        LibroService libroService = new LibroService(biblioteca);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        UsuarioService usuarioService = new UsuarioService(usuarios);

        Scanner teclado = new Scanner(System.in);

        int opcion;


        do {
            System.out.println("**Menú biblioteca**");
            System.out.println("1. Crear Libro");
            System.out.println("2. Actualizar Libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Crear Usuario");
            System.out.println("5. Actualizar Usuario");
            System.out.println("6. Eliminar usuario");
            System.out.println("7. Listar libros");
            System.out.println("8. Buscar libro por ISBN");
            System.out.println("9. Buscar libro por titulo");
            System.out.println("10. Prestar libro");
            System.out.println("11. Devolver libro");
            System.out.println("12. Salir");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el título del libro: ");
                    String titulo = teclado.nextLine();
                    System.out.println("Ingrese el autor del libro: ");
                    String autor = teclado.nextLine();
                    System.out.println("Ingrese el ISBN del libro: ");
                    String ISBN = teclado.nextLine();
                    System.out.println("Ingrese el género del libro: ");
                    String genero = teclado.nextLine();
                    libroService.crearLIbro(titulo, autor, ISBN, genero);
                    System.out.println("Libro agregado exitosamente");
                    break;
                case 2:
                    System.out.println("Ingrese el ISBN del libro a actualizar: ");
                    String ISBNActualizar = teclado.nextLine();
                    Libro libroAActualizar = libroService.libroPorISBN((ISBNActualizar));

                    System.out.println("Ingrese el nuevo título del libro: ");
                    String nuevoTitulo = teclado.nextLine();

                    System.out.println("Ingrese el nuevo Autor del libro: ");
                    String nuevoAutor = teclado.nextLine();

                    System.out.println("Ingrese el ISBN del libro: ");
                    String nuevoISBN = teclado.nextLine();

                    System.out.println("Ingrese el nuevo genero del libro: ");
                    String nuevoGenero = teclado.nextLine();

                    String tituloNew = libroAActualizar.getTitulo();
                    String ISBNNew = libroAActualizar.getISBN();

                    libroService.actualizarLIbro(tituloNew,nuevoAutor, nuevoISBN,nuevoGenero);

                    System.out.println("Libro actualizado exitosamente");

                    break;
                case 3:
                    System.out.println("Ingrese el ISBN del libro a eliminar: ");
                    String ISBNdelete = teclado.nextLine();
                    Libro libro = libroService.libroPorISBN(ISBNdelete);
                    if (libro != null) {
                        libroService.eliminarLibro(ISBNdelete);
                        System.out.println("Libro eliminado exitosamente");
                    } else {
                        System.out.println("No se encontró un libro con el ISBN " + ISBNdelete);
                    }
                    break;
                case 4:
                    System.out.println("Ingrese su nombre: ");
                    String nombreCreate = teclado.nextLine();

                    System.out.println("Ingrese un ID único: ");
                    String idCreate = teclado.nextLine();
                    usuarioService.crearUsuario(nombreCreate, idCreate);

                    break;
                case 5:
                    System.out.println("Ingrese el ID del usuario: ");
                    String idUsuarioUpdate = teclado.nextLine();

                    System.out.println("Ingrese el nombre del usuario: ");
                    String nombreUpdate = teclado.nextLine();
                    System.out.println("Ingrese el ID del usuario a actualizar: ");
                    String idUsuarioUpdateNew = teclado.nextLine();

                    System.out.println("Ingrese el nuevo nombre del usuario: ");
                    String nombreUpdateNew = teclado.nextLine();
                    usuarioService.actualizarUsuario(nombreUpdate,idUsuarioUpdate,nombreUpdateNew,idUsuarioUpdateNew);

                    break;
                case 6:
                    System.out.println("Ingrese el ID del usuario: ");
                    String idUsuarioDelete = teclado.nextLine();
                    usuarioService.eliminarUsuario(idUsuarioDelete);

                    break;
                case 7:
                    System.out.println("2. Lista de libros");
                    ArrayList<Libro> libros = libroService.obtenerTodaBiblioteca();
                    for (Libro libroList : libros) {
                        System.out.println("Título: " + libroList.getTitulo());
                        System.out.println("Autor: " + libroList.getAutor());
                        System.out.println("ISBN: " + libroList.getISBN());
                        System.out.println("Género: " + libroList.getGenero());
                        System.out.println();
                    }
                    break;
                case 8:
                    System.out.println("Ingrese el ISBN del libro: ");
                    String ISBNSearch = teclado.nextLine();
                    libroService.libroPorISBN(ISBNSearch);

                    break;
                case 9:
                    System.out.println("Ingrese el titulo del libro: ");
                    String tituloSearch = teclado.nextLine();
                    libroService.buscarLibroPorTitulo(tituloSearch);
                    break;
                case 10:

                    System.out.println("Ingrese el ISBN del libro: ");
                    String ISBNPrestamo = teclado.nextLine();
                    Libro libroPrestamo = libroService.libroPorISBN(ISBNPrestamo);

                    System.out.println("Ingrese el ID del usuario: ");
                    String idUsuario = teclado.nextLine();
                    Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);

                    if (libroPrestamo != null && usuario != null) {
                        if (libroPrestamo.isDisponible()) {
                            usuarioService.prestarLibro(usuario, libroPrestamo);
                            System.out.println("Libro prestado exitosamente");
                        } else {
                            System.out.println("El libro no está disponible");
                        }
                    } else {
                        System.out.println("No se encontró el libro o el usuario");
                    }


                    break;
                case 11:
                    System.out.println("Ingrese el ISBN del libro: ");
                    String ISBNDevolucion = teclado.nextLine();
                    Libro libroDevolucion = libroService.libroPorISBN(ISBNDevolucion);

                    System.out.println("Ingrese el ID del usuario: ");
                    String idUsuarioDevolucion = teclado.nextLine();
                    Usuario usuarioDevolucion = usuarioService.buscarUsuarioPorId(idUsuarioDevolucion);

                    if (libroDevolucion != null && usuarioDevolucion != null) {
                        if (libroDevolucion.isDisponible()) {
                            usuarioService.devolverLibro(usuarioDevolucion, libroDevolucion);
                            System.out.println("Libro fue devuelto exitosamente");
                        } else {
                            System.out.println("El libro no está disponible");
                        }
                    } else {
                        System.out.println("No se encontró el libro o el usuario");
                    }
                    break;
                case 12:

                    break;

                default:
                    // código a ejecutar si la expresión no coincide con ningún caso
            }

        } while (opcion <=11&&opcion>=1);


    }
}