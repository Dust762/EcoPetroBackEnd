package cl.com.dsf.ecoPetro.service.tipoUsuario;

import cl.com.dsf.ecoPetro.modelo.TipoUsuario;
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

@Path("/tipousuarios")
@Stateless
public class TipoUsuarioRS {
    @Inject
    private TipoUsuarioService tus;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoUsuario> listarTiposUsuarios() {
        return tus.mostrarTiposUsuarios();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /tipoUsuarios/{id}
    public TipoUsuario encontrarTipoUsuarioPorId(@PathParam("id") int id) {
        return tus.encontrarTipoUsuarioPorId(new TipoUsuario(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarTipoUsuario(TipoUsuario tu) {
        try {
            tus.agregarTipoUsuario(tu);
            
            return Response.ok().entity(tu).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarTipoUsuario(@PathParam("id") int id, TipoUsuario tuMod) {
        try {
            TipoUsuario tu = tus.encontrarTipoUsuarioPorId(new TipoUsuario(id));
            if (tu != null) {
                tus.modificarTipoUsuario(tu);
                return Response.ok().entity(tuMod).build();
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
    public Response eliminarTipoUsuarioPorId(@PathParam("id") int id) {
        try {
            tus.eliminarTipoUsuario(new TipoUsuario(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
