package cl.com.dsf.ecoPetro.data.tipoUsuario;

import cl.com.dsf.ecoPetro.modelo.TipoUsuario;
import java.util.List;

public interface tipoUsuarioDao {
    public List<TipoUsuario> mostrarTiposUsuarios();
    
    public TipoUsuario encontrarTipoUsuarioPorId(TipoUsuario tu);
    
    public void agregarTipoUsuario(TipoUsuario tu);
    
    public void modificarTipoUsuario(TipoUsuario tu);
    
    public void eliminarTipoUsuario(TipoUsuario tu);
}
