package cl.com.dsf.ecoPetro.service.tipoUsuario;

import cl.com.dsf.ecoPetro.modelo.TipoUsuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TipoUsuarioService {
    public List<TipoUsuario> mostrarTiposUsuarios();
    
    public TipoUsuario encontrarTipoUsuarioPorId(TipoUsuario tu);
    
    public void agregarTipoUsuario(TipoUsuario tu);
    
    public void modificarTipoUsuario(TipoUsuario tu);
    
    public void eliminarTipoUsuario(TipoUsuario tu);
}
