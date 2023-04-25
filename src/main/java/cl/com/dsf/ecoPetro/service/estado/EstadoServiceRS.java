package cl.com.dsf.ecoPetro.service.estado;

import cl.com.dsf.ecoPetro.modelo.Estado;
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

@Path("/estados")
@Stateless
public class EstadoServiceRS {
    @Inject
    private EstadoService es;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Estado> listarEstados() {
        return es.mostrarEstados();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /fallos/{id}
    public Estado encontrarEstadoPorId(@PathParam("id") int id) {
        return es.encontrarEstadoPorId(new Estado(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarEstado(Estado e) {
        try {
            es.crearEstado(e);
            return Response.ok().entity(e).build();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarEstado(@PathParam("id") int id, Estado eMod) {
        try {
            Estado e = es.encontrarEstadoPorId(new Estado(id));
            if (e != null) {
                es.modificarEstado(e);
                return Response.ok().entity(eMod).build();
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
    public Response eliminarEstadoPorId(@PathParam("id") int id) {
        try {
            es.eliminarEstado(new Estado(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
