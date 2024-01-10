/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_5_mgn.controlador;

import ec.edu.ups.practica_5_mgn.modelo.Libro;
import ec.edu.ups.practica_5_mgn.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public class ControladorLibro {

    private List<Libro> listaLibros;
    private ControladorUsuario usuarioControlador;

    public ControladorLibro(ControladorUsuario usuarioControlador) {
        this.listaLibros = new ArrayList<>();
        this.usuarioControlador = usuarioControlador;
    }

    public void guardarLibro(Libro libro) {
        listaLibros.add(libro);
        System.out.println("Libro guardado en la base de datos.");
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : listaLibros) {
            System.out.println("Título del libro: " + libro.getTitulo());
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public Usuario obtenerUsuarioQuePrestoLibro(Libro libro) {
        return usuarioControlador.obtenerUsuarioQuePrestoLibro(libro);
    }

    public void marcarLibroComoDisponible(Libro libro) {
        // Encontrar el libro en la lista y marcarlo como disponible
        for (Libro l : listaLibros) {
            if (l.equals(libro)) {
                l.setDisponible(true);
                System.out.println("Libro marcado como disponible: " + l.getTitulo());
                break;
            }
        }
    }

    public boolean actualizarLibro(Libro libroActualizado) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(libroActualizado.getTitulo())) {
                // Actualizar todos los datos del libro existente con los datos del libro actualizado
                libro.setTitulo(libroActualizado.getTitulo());
                libro.setAutor(libroActualizado.getAutor());
                libro.setAño(libroActualizado.getAño());

                System.out.println("Libro actualizado: " + libro.getTitulo());
                return true; // Indicar que la actualización fue exitosa
            }
        }
        return false; // Indicar que el libro no fue encontrado para actualizar
    }

    public boolean eliminarLibro(String titulo) {
        Libro libroEncontrado = buscarLibroPorTitulo(titulo);
        if (libroEncontrado != null) {
            listaLibros.remove(libroEncontrado);
            System.out.println("Libro eliminado: " + libroEncontrado.getTitulo());
            return true; // Indica que el libro fue eliminado correctamente
        }
        return false; // Indica que no se encontró el libro para eliminarlo
    }

}
