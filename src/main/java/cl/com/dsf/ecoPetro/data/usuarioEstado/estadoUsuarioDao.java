package cl.com.dsf.ecoPetro.data.usuarioEstado;

import cl.com.dsf.ecoPetro.modelo.EstadoUsuario;
import java.util.List;

public interface estadoUsuarioDao {
    public List<EstadoUsuario> mostrarEstadosUsuarios();
    
    public EstadoUsuario encontrarEstadoUsuarioPorId(EstadoUsuario eu);
    
    public void agregarEstadoUsuario(EstadoUsuario eu);
    
    public void modificarEstadoUsuario(EstadoUsuario eu);
    
    public void eliminarEstadoUsuario(EstadoUsuario eu);
}
