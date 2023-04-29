package cl.com.dsf.ecoPetro.service.ltCombustible;

import cl.com.dsf.ecoPetro.modelo.Ltcombustible;
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

@Path("/ltcombustibles")
@Stateless
public class ltCombustibleServiceRS {
    @Inject
    private ltCombustibleService lcs;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Ltcombustible> listarLtCombustibles() {
        return lcs.mostrarLtCombustibles();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /ltcombustibles/{id}
    public Ltcombustible encontrarLtCombustiblePorId(@PathParam("id") int id) {
        return lcs.encontrarLtCombustiblePorId(new Ltcombustible(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response agregarLtCombustible(Ltcombustible lc) {
        try {
            lcs.agregarLtCombustible(lc);
            
            return Response.ok().entity(lc).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarLtCombustible(@PathParam("id") int id, Ltcombustible lcMod) {
        try {
            Ltcombustible lc = lcs.encontrarLtCombustiblePorId(new Ltcombustible(id));
            if (lc != null) {
                lcs.modificarLtCombustible(lc);
                return Response.ok().entity(lcMod).build();
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
    public Response eliminarLtCombustiblePorId(@PathParam("id") int id) {
        try {
            lcs.eliminarLtCombustible(new Ltcombustible(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
