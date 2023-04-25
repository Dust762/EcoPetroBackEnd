
package cl.com.dsf.ecoPetro.service.camion;

import cl.com.dsf.ecoPetro.modelo.Camion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CamionService {
    public List<Camion> listarCamiones();
    
    public Camion encontrarCamionPorId(Camion c);
    
    public Camion encontrarCamionPorPatente(Camion c);
    
    public void registrarCamion(Camion c);
    
    public void actualizarCamion(Camion c);
    
    public void eliminarCamion(Camion c);
}
