package cl.com.dsf.ecoPetro.service.usuarioEstado;

import cl.com.dsf.ecoPetro.modelo.EstadoUsuario;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EstadoUsuarioWs {
    @WebMethod
    public List<EstadoUsuario> mostrarEstadosUsuarios();
}
