/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_5_mgn.dao;

import ec.edu.ups.practica_5_mgn.idao.PrestamoIDAO;
import ec.edu.ups.practica_5_mgn.modelo.Prestamo;
import ec.edu.ups.practica_5_mgn.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public class PrestamoDAO implements PrestamoIDAO {
    private List<Prestamo> listaPrestamos; // Suponiendo que esta lista se inicializa y gestiona los préstamos

    public PrestamoDAO() {
        // Inicialización de la lista de préstamos
        this.listaPrestamos = new ArrayList<>();
    }

    @Override
    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    @Override
    public List<Prestamo> obtenerPrestamosPorUsuario(Usuario usuario) {
        List<Prestamo> prestamosUsuario = new ArrayList<>();
        // Iterar la lista para encontrar los préstamos del usuario dado
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getUsuario().equals(usuario)) {
                prestamosUsuario.add(prestamo);
            }
        }
        return prestamosUsuario; // Devuelve la lista de préstamos del usuario
    }

    @Override
    public void eliminarPrestamo(Prestamo prestamo) {
        listaPrestamos.remove(prestamo);
    }

    @Override
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return listaPrestamos; // Devuelve toda la lista de préstamos
    }
}
