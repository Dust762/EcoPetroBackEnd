package cl.com.dsf.ecoPetro.service.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.Estadocamion;
import java.util.List;
import javax.ejb.Local;
@Local
public interface EstadoCamionService {
    public List<Estadocamion> mostrarEstadoCamiones();

    public Estadocamion encontrarEstadoPorId(Estadocamion ec);

    public void crearEstadoCamion(Estadocamion ec);

    public void modificarEstadoCamion(Estadocamion ec);

    public void eliminarEstadoCamion(Estadocamion ec);
}
