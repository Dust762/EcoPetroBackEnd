package cl.com.dsf.ecoPetro.service.fotoUsuario;

import cl.com.dsf.ecoPetro.modelo.FotoUsuario;
import java.util.List;
import javax.ejb.Local;
@Local
public interface FotoUsuarioService {
    public List<FotoUsuario> mostrarFotoUsuarios();
    
    public FotoUsuario encontrarFotoUsuarioPorId(FotoUsuario fu);
    
    public void agregarFotoUsuario(FotoUsuario fu);
    
    public void actualizarFotoUsuario(FotoUsuario fu);
    
    public void eliminarFotoUsuario(FotoUsuario fu);
}
