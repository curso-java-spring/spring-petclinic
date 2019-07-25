package org.springframework.samples.petclinic.service;

import java.io.IOException;

import org.springframework.samples.petclinic.sensor.HumiditySensor;

import com.fasterxml.jackson.core.JsonGenerator;

import com.fasterxml.jackson.databind.SerializerProvider;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JacksonCustomSensorSerializer  extends StdSerializer<HumiditySensor> {

	private static final long serialVersionUID = 1L;

	public JacksonCustomSensorSerializer() {
		this(null);
	}

	public JacksonCustomSensorSerializer(Class<HumiditySensor> s) {
		super(s);
	}

	@Override
	public void serialize(HumiditySensor sensor, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		
		if (sensor.getId() == null) {
			
			jgen.writeNullField("id");
			
		} else {
			jgen.writeNumberField("id", sensor.getId());
			
		}		
		jgen.writeStringField("name", sensor.getName());
		jgen.writeNumberField("humidity", sensor.getHumidity());
	}

}
