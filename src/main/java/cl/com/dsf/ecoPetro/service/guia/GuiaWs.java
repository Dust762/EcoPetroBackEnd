package cl.com.dsf.ecoPetro.service.guia;

import cl.com.dsf.ecoPetro.modelo.Guia;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface GuiaWs {
    @WebMethod
    public List<Guia> mostrarGuias();
}
