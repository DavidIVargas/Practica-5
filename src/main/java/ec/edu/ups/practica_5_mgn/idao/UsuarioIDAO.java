/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica_5_mgn.idao;
import ec.edu.ups.practica_5_mgn.modelo.Usuario;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public interface UsuarioIDAO {
    void agregarUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(String id);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Usuario usuario);
    List<Usuario> obtenerTodosLosUsuarios();
}
