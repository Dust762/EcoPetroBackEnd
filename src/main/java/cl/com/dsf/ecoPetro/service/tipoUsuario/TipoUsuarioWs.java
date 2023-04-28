package cl.com.dsf.ecoPetro.service.tipoUsuario;

import cl.com.dsf.ecoPetro.modelo.TipoUsuario;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TipoUsuarioWs {
    @WebMethod
    public List<TipoUsuario> mostrarTiposUsuarios();
}
