/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.com.dsf.ecoPetro.resources;

import java.util.Locale;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.eclipse.yasson.YassonConfig;
@Provider
public class JsonbConfigProperties implements ContextResolver<Jsonb>{
    private static Jsonb instance;
    @Override
    public Jsonb getContext(Class<?> type) {
        return getInstance();
    }

    private Jsonb getInstance() {
        if (instance == null) {
            javax.json.bind.JsonbConfig config = new javax.json.bind.JsonbConfig()
                .withDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ",null).setProperty(YassonConfig.ZERO_TIME_PARSE_DEFAULTING, true)
                .setProperty(JsonbConfig.DATE_FORMAT,"yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            instance = JsonbBuilder.create(config);
        }
        return instance;
    }
}
