package cl.com.dsf.ecoPetro.data.viaje;

import cl.com.dsf.ecoPetro.modelo.Viaje;
import java.util.List;

public interface viajeDao {
    public List<Viaje> mostrarViajes();
    
    public Viaje encontrarViajePorId(Viaje v);
    
    public void crearViaje(Viaje v);
    
    public void modificarViaje(Viaje v);
    
    public void eliminarViaje(Viaje v);
}
