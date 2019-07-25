package org.springframework.samples.petclinic.sensor;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.samples.petclinic.plant.Plant;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(HumiditySensorController.class)
public class HumiditySensorControllerTest {
	
	private static final int TEST_HUMIDITY_SENSOR_ID = 1;
	private static final int TEST_PLANT_ID = 1;
	
	@Autowired
	private MockMvc mockMvc;	
	
    @MockBean
    private HumiditySensorRepository sensor;
	
	private HumiditySensor sensor1;
	private Plant plantTest;
	
	@Before
	public void setup() {
		
		plantTest = new Plant();
		plantTest.setId(TEST_PLANT_ID);
		plantTest.setMessage("A umidade da planta esta dentro da faixa ideal");
		plantTest.setHumidity_minimum(60);
		plantTest.setHumidity_maximum(80);
		plantTest.setName("Strawberry");
		
		sensor1 = new HumiditySensor();
		sensor1.setId(TEST_HUMIDITY_SENSOR_ID);
		sensor1.setHumidity(60);
		sensor1.setName("Sensor1");
		sensor1.setPlant(plantTest);
		given(this.sensor.findById(TEST_HUMIDITY_SENSOR_ID)).willReturn(sensor1);
	}
	
	@Test
	public void testShowHumiditySensorDetailsNotFound() throws Exception{
		given(this.sensor.findById(-1)).willReturn(null);
	}
	
	@Test
	public void testShowHumiditySensorDetails() throws Exception{
        mockMvc.perform(get("/sensors/{sensorId}", TEST_HUMIDITY_SENSOR_ID))
        .andExpect(status().isOk())
        .andExpect(model().attribute("humiditySensor", hasProperty("id", is(TEST_HUMIDITY_SENSOR_ID))))
        .andExpect(model().attribute("humiditySensor", hasProperty("name", is("Sensor1"))))
        .andExpect(model().attribute("humiditySensor", hasProperty("humidity", is(60))))
        .andExpect(model().attribute("humiditySensor", hasProperty("plant", is(plantTest))))
        .andExpect(view().name("sensors/sensorsDetails"));
	}

}
