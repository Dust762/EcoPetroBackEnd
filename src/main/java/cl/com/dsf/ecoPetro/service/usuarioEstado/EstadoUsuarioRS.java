package cl.com.dsf.ecoPetro.service.usuarioEstado;

import cl.com.dsf.ecoPetro.modelo.EstadoUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/estadousuarios")
@Stateless
public class EstadoUsuarioRS {
    @Inject
    EstadoUsuarioService eus;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<EstadoUsuario> listarEstadosUsuarios() {
        return eus.mostrarEstadosUsuarios();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /estadousuarios/{id}
    public EstadoUsuario encontrarEstadoUsuarioPorId(@PathParam("id") int id) {
        return eus.encontrarEstadoUsuarioPorId(new EstadoUsuario(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarEstadoUsuario(EstadoUsuario eu) {
        try {
            eus.agregarEstadoUsuario(eu);
            
            return Response.ok().entity(eu).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarEstadoUsuario(@PathParam("id") int id, EstadoUsuario euMod) {
        try {
            EstadoUsuario eu = eus.encontrarEstadoUsuarioPorId(new EstadoUsuario(id));
            if (eu != null) {
                eus.modificarEstadoUsuario(eu);
                return Response.ok().entity(euMod).build();
            }else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarEstadoUsuarioPorId(@PathParam("id") int id) {
        try {
            eus.eliminarEstadoUsuario(new EstadoUsuario(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
