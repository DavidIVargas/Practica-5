/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_5_mgn.dao;

import ec.edu.ups.practica_5_mgn.idao.UsuarioIDAO;
import ec.edu.ups.practica_5_mgn.modelo.Usuario;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public class UsuarioDAO implements UsuarioIDAO {
    private List<Usuario> listaUsuarios; // Suponiendo que esta lista se inicializa y gestiona los usuarios

    // Implementación de métodos de la interfaz UsuarioIDAO
    @Override
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(String id) {
        // Iterar la lista para encontrar el usuario por su ID
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdentificacion().equals(id)) {
                return usuario;
            }
        }
        return null; // Si no se encuentra el usuario
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        // Lógica para actualizar un usuario existente
        // Puedes buscar el usuario por ID y actualizar sus atributos
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return listaUsuarios; // Devuelve toda la lista de usuarios
    }
}
