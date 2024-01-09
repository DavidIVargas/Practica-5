/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_5_mgn.modelo;

import java.util.ArrayList;

/**
 *
 * @author davidvargas
 */
public class Usuario extends Persona {

    private String correo;
    private ArrayList<Prestamo> listaPrestamos;

    public Usuario(String nombre, String identificacion, String correo) {
        super(nombre, identificacion);
        this.correo = correo;
        this.listaPrestamos = new ArrayList<>();
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificación: " + identificacion);
        System.out.println("Correo: " + correo);
    }

    public void solicitarPrestamo(Libro libro) {
        if (libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(libro, this);
            libro.prestar();
            agregarPrestamo(prestamo);
            System.out.println("Préstamo solicitado CORRECTAMENTE.");
        } else {
            System.out.println("El libro no está disponible para préstamo ☹️.");
        }
    }

    public boolean devolverLibro(Libro libro) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro().equals(libro) && prestamo.esPrestamoVigente()) {
                listaPrestamos.remove(prestamo);
                return true;
            }
        }
        return false;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    public Iterable<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public Libro obtenerLibroPrestado(String tituloLibro) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro().getTitulo().equalsIgnoreCase(tituloLibro) && prestamo.esPrestamoVigente()) {
                return prestamo.getLibro();
            }
        }
        return null;
    }

    public boolean eliminarPrestamo(Libro libro) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro().equals(libro)) {
                listaPrestamos.remove(prestamo);
                return true;
            }
        }
        return false;
    }
    

    @Override
    public String toString() {
        return "Usuario{"
                + "nombre='" + nombre + '\''
                + ", identificacion='" + identificacion + '\''
                + ", correo='" + correo + '\''
                + '}';
    }

}
