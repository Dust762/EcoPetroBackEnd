package cl.com.dsf.ecoPetro.web;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
@ApplicationPath("ecoPetroAPI")
public class AppConfiguration extends ResourceConfig{

    public AppConfiguration() {
        packages("cl.com.dsf.ecoPetro").register(MultiPartFeature.class);
    }
    
}
