package cl.com.dsf.ecoPetro.data.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.EstadoCamion;
import java.util.List;

public interface estadoCamionDao {
    public List<EstadoCamion> mostrarEstadoCamiones();
    
    public EstadoCamion encontrarEstadoCamionPorId(EstadoCamion ec);
    
    public void agregarEstadoCamion(EstadoCamion ec);
    
    public void modificarEstadoCamion(EstadoCamion ec);
    
    public void eliminarEstadoCamion(EstadoCamion ec);
}
