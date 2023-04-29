package cl.com.dsf.ecoPetro.service.carga;

import cl.com.dsf.ecoPetro.modelo.Carga;
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

@Path("/cargas")
@Stateless
public class CargaRS {
    @Inject
    CargaService cs;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Carga> listarCargas() {
        return cs.mostrarCargas();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /cargas/{id}
    public Carga encontrarCargaPorId(@PathParam("id") int id) {
        return cs.encontrarCargaPorId(new Carga(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response crearCarga(Carga c) {
        try {
            cs.crearCarga(c);
            
            return Response.ok().entity(c).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarCarga(@PathParam("id") int id, Carga cMod) {
        try {
            Carga c = cs.encontrarCargaPorId(new Carga(id));
            if (c != null) {
                cs.actualizarCarga(c);
                return Response.ok().entity(cMod).build();
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
    public Response eliminarCargaPorId(@PathParam("id") int id) {
        try {
            cs.eliminarCarga(new Carga(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
