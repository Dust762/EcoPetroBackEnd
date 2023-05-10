package cl.com.dsf.ecoPetro.resources;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
//import com.sun.xml.internal.ws.util.StringUtils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateDeserializer extends JsonDeserializer<Date> {

    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final String ISO_DATE = ("yyyy-MM-dd'T'HH:mm'Z'");
	private SimpleDateFormat formatter;

	public DateDeserializer() {
		super();
		this.formatter = new SimpleDateFormat(ISO_DATE);
	}

	public DateDeserializer(String dateFormat) {
		super();
		if (!dateFormat.isEmpty())
                    this.formatter = new SimpleDateFormat(dateFormat);
		else
                    this.formatter = new SimpleDateFormat(ISO_DATE);
	}

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String timestamp = jp.getText().trim();
		try {
			return formatter.parse(timestamp);
		} catch (ParseException e) {
			//logger.warn(e.getMessage());
			return new Date();
		}
	}
}
