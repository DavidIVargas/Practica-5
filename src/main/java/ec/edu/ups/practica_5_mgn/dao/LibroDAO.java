/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_5_mgn.dao;

import ec.edu.ups.practica_5_mgn.idao.LibroIDAO;
import ec.edu.ups.practica_5_mgn.modelo.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public class LibroDAO implements LibroIDAO {
    private List<Libro> listaLibros; // Suponiendo que esta lista se inicializa y gestiona los libros

    public LibroDAO() {
        // Inicialización de la lista de libros
        this.listaLibros = new ArrayList<>();
    }

    @Override
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    @Override
    public Libro obtenerLibroPorTitulo(String titulo) {
        // Iterar la lista para encontrar el libro por su título
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro
    }

    @Override
    public void actualizarLibro(Libro libro) {
        // Lógica para actualizar un libro existente
        // Puedes buscar el libro por título o ID y actualizar sus atributos
    }

    @Override
    public void eliminarLibro(Libro libro) {
        listaLibros.remove(libro);
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return listaLibros; // Devuelve toda la lista de libros
    }
}
