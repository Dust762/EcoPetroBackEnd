package cl.com.dsf.ecoPetro.service.viaje;

import cl.com.dsf.ecoPetro.modelo.Viaje;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ViajeServiceRemote {
    public List<Viaje> mostrarViajes();
    
    public Viaje encontrarViajePorId(Viaje v);
    
    public void crearViaje(Viaje v);
    
    public void modificarViaje(Viaje v);
    
    public void eliminarViaje(Viaje v);
}
