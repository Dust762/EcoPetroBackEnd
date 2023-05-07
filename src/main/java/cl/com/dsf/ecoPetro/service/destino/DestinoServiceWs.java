package cl.com.dsf.ecoPetro.service.destino;

import cl.com.dsf.ecoPetro.modelo.Destino;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface DestinoServiceWs {
    @WebMethod
    public List<Destino> mostrarDestinos();
  
}
