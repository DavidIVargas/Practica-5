/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_5_mgn.controlador;

import ec.edu.ups.practica_5_mgn.modelo.Biblioteca;
import ec.edu.ups.practica_5_mgn.modelo.Libro;
import ec.edu.ups.practica_5_mgn.modelo.Prestamo;
import ec.edu.ups.practica_5_mgn.modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author davidvargas
 */
public class ControladorUsuario {

    private List<Usuario> listaUsuarios;
    private Map<String, Usuario> usuariosPorId;
    private Biblioteca biblioteca;

    public ControladorUsuario(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.listaUsuarios = new ArrayList<>();
        this.usuariosPorId = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario) {
        biblioteca.registrarUsuario(usuario);
    }

    public void solicitarPrestamo(Usuario usuario, Libro libro) {
        usuario.solicitarPrestamo(libro);
    }

    public boolean devolverLibro(Usuario usuario, Libro libro) {
        for (Prestamo prestamo : usuario.getListaPrestamos()) {
            if (prestamo.getLibro().equals(libro) && prestamo.esPrestamoVigente()) {
                usuario.eliminarPrestamo(libro);
                libro.setDisponible(true);
                return true;
            }
        }
        return false;
    }

    public void guardarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        usuariosPorId.put(usuario.getIdentificacion(), usuario);
        System.out.println("Usuario guardado en la base de datos.");
    }

    public Usuario buscarUsuarioPorId(String identificacion) {
        return usuariosPorId.get(identificacion);
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Usuario usuario : listaUsuarios) {
            for (Prestamo prestamo : usuario.getListaPrestamos()) {
                if (prestamo.getLibro().getTitulo().equalsIgnoreCase(titulo)) {
                    return prestamo.getLibro();
                }
            }
        }
        return null;
    }

    public Usuario obtenerUsuarioQuePrestoLibro(Libro libro) {
        for (Usuario usuario : listaUsuarios) {
            for (Prestamo prestamo : usuario.getListaPrestamos()) {
                if (prestamo.getLibro().equals(libro) && prestamo.esPrestamoVigente()) {
                    return usuario;
                }
            }
        }
        return null;
    }

    public Prestamo obtenerPrestamo(Usuario usuario, Libro libro) {
        for (Prestamo prestamo : usuario.getListaPrestamos()) {
            if (prestamo.getLibro().equals(libro)) {
                return prestamo;
            }
        }
        return null;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        // Verificar si el usuario existe en la base de datos o sistema
        Usuario usuarioExistente = buscarUsuarioPorId(usuario.getIdentificacion());

        if (usuarioExistente != null) {
            // Actualizar los campos del usuario existente con la información del usuario recibido
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setCorreo(usuario.getCorreo());

            // Guardar los cambios en la base de datos o sistema
            // (Aquí asumimos que el método guardarCambios() está definido para guardar los cambios en la base de datos)
            guardarCambios(usuarioExistente);

            return true; // La actualización fue exitosa
        } else {
            return false; // El usuario no existe, la actualización no fue posible
        }
    }
    public void guardarCambios(Usuario usuario) {
        // Buscar el usuario en la listaUsuarios y actualizarlo si existe
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario u = listaUsuarios.get(i);
            if (u.getIdentificacion().equals(usuario.getIdentificacion())) {
                listaUsuarios.set(i, usuario); // Reemplazar el usuario actual con el usuario actualizado
                break;
            }
        }

        // Actualizar también en el mapa de usuariosPorId
        usuariosPorId.put(usuario.getIdentificacion(), usuario);

        System.out.println("Cambios guardados correctamente.");
    }
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        usuariosPorId.put(usuario.getIdentificacion(), usuario);
    }

    public boolean eliminarUsuario(String identificacion) {
        Usuario usuarioAEliminar = usuariosPorId.get(identificacion);
        if (usuarioAEliminar != null) {
            listaUsuarios.remove(usuarioAEliminar);
            usuariosPorId.remove(identificacion);
            return true;
        }
        return false;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return listaUsuarios;
    }
}
