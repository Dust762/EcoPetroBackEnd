package cl.com.dsf.ecoPetro.service.chofer;

import cl.com.dsf.ecoPetro.modelo.Chofer;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ChoferServiceRemote {
    public List<Chofer> mostrarChoferes();
    
    public Chofer encontrarChoferPorId(Chofer c);
    
    public void agregarChofer(Chofer c);
    
    public void modificarChofer(Chofer c);
    
    public void eliminarChofer(Chofer c);
}
