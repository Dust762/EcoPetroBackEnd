
package cl.com.dsf.ecoPetro.service.camion;

import cl.com.dsf.ecoPetro.modelo.Camion;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CamionServiceWs {
    @WebMethod
    public List<Camion> listarCamiones();
}
