package cl.com.dsf.ecoPetro.data.usuario;

import cl.com.dsf.ecoPetro.modelo.Usuario;
import java.util.List;

public interface usuarioDao {
    public List<Usuario> mostrarUsuarios();
    
    public Usuario encontrarUsuarioPorId(Usuario u);
    
    public void agregarUsuario(Usuario u);
    
    public void modificarUsuario(Usuario u);
    
    public void eliminarUsuario(Usuario u);
}
