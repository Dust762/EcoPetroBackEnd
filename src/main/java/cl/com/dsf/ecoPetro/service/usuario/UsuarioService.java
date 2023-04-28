package cl.com.dsf.ecoPetro.service.usuario;

import cl.com.dsf.ecoPetro.modelo.Usuario;
import java.util.List;
import javax.ejb.Local;
@Local
public interface UsuarioService {
    public List<Usuario> mostrarUsuarios();
    
    public Usuario encontrarUsuarioPorId(Usuario u);
    
    public void agregarUsuario(Usuario u);
    
    public void modificarUsuario(Usuario u);
    
    public void eliminarUsuario(Usuario u);
}
