package cl.com.dsf.ecoPetro.service.ltCombustible;

import cl.com.dsf.ecoPetro.modelo.Ltcombustible;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarLtCombustible(Ltcombustible lc) {
        try {
            lcs.agregarLtCombustible(lc);

            return Response.ok().entity(lc).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    /*
    //EXPERIMENTAL
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("fotoCombustible/{id}")
    public Response agregarLtCombustible(@DefaultValue("true") @FormDataParam("enabled") boolean enabled,
            @FormDataParam("foto") InputStream uploadedInputStream,
            @FormDataParam("foto") FormDataContentDisposition datoArchivo, @PathParam("id") int id) {
       
        
        
        String ubicacion = "D://fotoCombustible/" + datoArchivo.getFileName();
        File objFile = new File(ubicacion);
        if (objFile.exists()) {

            objFile.delete();

        }
        saveToFile(uploadedInputStream, ubicacion);
        Ltcombustible lc = lcs.encontrarLtCombustiblePorId(new Ltcombustible(id));
        lc.setRutaFotoCargas(ubicacion);

        try {
            lcs.modificarLtCombustible(lc);
            return Response.ok().entity(lc).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    private void saveToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) {

        try {
            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        
    }
    */
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
            } else {
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
