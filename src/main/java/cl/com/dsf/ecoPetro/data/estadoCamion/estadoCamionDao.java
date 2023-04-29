package cl.com.dsf.ecoPetro.data.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.Estadocamion;
import java.util.List;

public interface estadoCamionDao {
    public List<Estadocamion> mostrarEstadoCamiones();
    
    public Estadocamion encontrarEstadoCamionPorId(Estadocamion ec);
    
    public void agregarEstadoCamion(Estadocamion ec);
    
    public void modificarEstadoCamion(Estadocamion ec);
    
    public void eliminarEstadoCamion(Estadocamion ec);
}
