package cl.com.dsf.ecoPetro.service.estadoCamion;

import cl.com.dsf.ecoPetro.modelo.Estadocamion;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EstadoCamionServiceWs {
    @WebMethod
    public List<Estadocamion> mostrarEstadoCamiones();
}
