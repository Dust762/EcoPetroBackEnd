package cl.com.dsf.ecoPetro.service.viaje;

import cl.com.dsf.ecoPetro.modelo.Viaje;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface ViajeWs {
    @WebMethod
    public List<Viaje> mostrarViajes();
}
