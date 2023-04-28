package cl.com.dsf.ecoPetro.service.usuarioEstado;

import cl.com.dsf.ecoPetro.modelo.EstadoUsuario;
import java.util.List;
import javax.ejb.Local;
@Local
public interface EstadoUsuarioService {
    public List<EstadoUsuario> mostrarEstadosUsuarios();
    
    public EstadoUsuario encontrarEstadoUsuarioPorId(EstadoUsuario eu);
    
    public void agregarEstadoUsuario(EstadoUsuario eu);
    
    public void modificarEstadoUsuario(EstadoUsuario eu);
    
    public void eliminarEstadoUsuario(EstadoUsuario eu);
}
