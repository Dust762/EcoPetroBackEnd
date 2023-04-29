package cl.com.dsf.ecoPetro.service.chofer;

import cl.com.dsf.ecoPetro.modelo.Chofer;
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

@Path("/choferes")
@Stateless
public class ChoferRS {
    @Inject
    ChoferService cs;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Chofer> listarChoferes() {
        return cs.mostrarChoferes();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /choferes/{id}
    public Chofer encontrarChoferPorId(@PathParam("id") int id) {
        return cs.encontrarChoferPorId(new Chofer(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarChofer(Chofer c) {
        try {
            cs.agregarChofer(c);
            
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
    public Response modificarChofer(@PathParam("id") int id, Chofer cMod) {
        try {
            Chofer c = cs.encontrarChoferPorId(new Chofer(id));
            if (c != null) {
                cs.modificarChofer(c);
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
    public Response eliminarChoferPorId(@PathParam("id") int id) {
        try {
            cs.eliminarChofer(new Chofer(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
