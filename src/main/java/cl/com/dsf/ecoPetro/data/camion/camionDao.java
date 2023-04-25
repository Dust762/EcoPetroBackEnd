package cl.com.dsf.ecoPetro.data.camion;

import cl.com.dsf.ecoPetro.modelo.Camion;
import java.util.List;

public interface camionDao {
    public List<Camion> mostrarCamiones();
    
    public Camion encontrarCamionPorId(Camion c);
    
    public void crearCamion(Camion c);
    
    public void actualizarCamion(Camion c);
    
    public void eliminarCamion(Camion c);
}
