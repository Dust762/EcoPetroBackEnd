package cl.com.dsf.ecoPetro.service.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.EstadoCamion;
import java.util.List;
import javax.ejb.Local;
@Local
public interface EstadoCamionService {
    public List<EstadoCamion> mostrarEstadoCamiones();

    public EstadoCamion encontrarEstadoPorId(EstadoCamion ec);

    public void crearEstadoCamion(EstadoCamion ec);

    public void modificarEstadoCamion(EstadoCamion ec);

    public void eliminarEstadoCamion(EstadoCamion ec);
}
