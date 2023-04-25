package cl.com.dsf.ecoPetro.data.estado;

import cl.com.dsf.ecoPetro.modelo.Estado;
import java.util.List;

public interface estadoDao {
    public List<Estado> mostrarEstados();
    
    public Estado encontrarEstadoPorId(Estado e);
    
    public void crearEstado(Estado e);
    
    public void modificarEstado(Estado e);
    
    public void eliminarEstado(Estado e);
}
