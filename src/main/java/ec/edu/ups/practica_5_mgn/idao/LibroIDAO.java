/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_5_mgn.idao;
import ec.edu.ups.practica_5_mgn.modelo.Libro;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public interface LibroIDAO {
    void agregarLibro(Libro libro);
    Libro obtenerLibroPorTitulo(String titulo);
    void actualizarLibro(Libro libro);
    void eliminarLibro(Libro libro);
    List<Libro> obtenerTodosLosLibros();
}
