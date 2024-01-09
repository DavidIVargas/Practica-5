/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_5_mgn.dao;

import ec.edu.ups.practica_5_mgn.idao.UsuarioIDAO;
import ec.edu.ups.practica_5_mgn.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public class UsuarioDAO implements UsuarioIDAO {
    private List<Usuario> listaUsuarios;

    public UsuarioDAO() {
        this.listaUsuarios = new ArrayList<>();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(String id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdentificacion().equalsIgnoreCase(id)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        // Lógica para actualizar un usuario existente
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return listaUsuarios;
    }
}
