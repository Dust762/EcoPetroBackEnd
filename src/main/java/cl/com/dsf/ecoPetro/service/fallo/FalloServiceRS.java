package cl.com.dsf.ecoPetro.service.fallo;

import cl.com.dsf.ecoPetro.modelo.Fallo;
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

@Path("/fallos")
@Stateless
public class FalloServiceRS {
    @Inject
    private FalloService fs;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Fallo> listarFallos() {
        return fs.mostrarFallos();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /fallos/{id}
    public Fallo encontrarFalloPorId(@PathParam("id") int id) {
        return fs.encontrarFalloPorId(new Fallo(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarFallo(Fallo f) {
        try {
            fs.agregarFallo(f);
            
            return Response.ok().entity(f).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarFallo(@PathParam("id") int id, Fallo fMod) {
        try {
            Fallo f = fs.encontrarFalloPorId(new Fallo(id));
            if (f != null) {
                fs.modificarFallo(f);
                return Response.ok().entity(fMod).build();
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
    public Response eliminarFalloPorId(@PathParam("id") int id) {
        try {
            fs.eliminarFallo(new Fallo(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
