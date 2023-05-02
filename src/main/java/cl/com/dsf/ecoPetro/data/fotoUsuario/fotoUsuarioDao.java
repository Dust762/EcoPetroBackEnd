package cl.com.dsf.ecoPetro.data.fotoUsuario;

import cl.com.dsf.ecoPetro.modelo.FotoUsuario;
import java.util.List;

public interface fotoUsuarioDao {
    public List<FotoUsuario> mostrarFotoUsuarios();
    
    public FotoUsuario encontrarFotoUsuarioPorId(FotoUsuario fu);
    
    public void agregarFotoUsuario(FotoUsuario fu);
    
    public void actualizarFotoUsuario(FotoUsuario fu);
    
    public void eliminarFotoUsuario(FotoUsuario fu);
}
