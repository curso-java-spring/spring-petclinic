package org.springframework.samples.petclinic.plant;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PlantController.class)
public class PlantControllerTest {
	
	private static final int TEST_PLANT_ID = 1;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PlantRepository plant;
	
	private Plant strawberry;
		
	@Before
	public void setup() {
		
		strawberry = new Plant();
		strawberry.setId(TEST_PLANT_ID);
		strawberry.setMessage("A umidade da planta esta dentro da faixa ideal");
		strawberry.setHumidity_minimum(60);
		strawberry.setHumidity_maximum(80);
		strawberry.setName("Strawberry");
		given(this.plant.findById(TEST_PLANT_ID)).willReturn(strawberry);
	}
	
	@Test
	public void testShowPlantDetailsNotFound() throws Exception{
		given(this.plant.findById(-1)).willReturn(null);
	}
	
	@Test
	public void testShowPlantDetails() throws Exception{
        mockMvc.perform(get("/plants/{plantId}", TEST_PLANT_ID))
        .andExpect(status().isOk())
        .andExpect(model().attribute("plant", hasProperty("id", is(TEST_PLANT_ID))))
        .andExpect(model().attribute("plant", hasProperty("name", is("Strawberry"))))
        .andExpect(model().attribute("plant", hasProperty("humidity_minimum", is(60))))
        .andExpect(model().attribute("plant", hasProperty("humidity_maximum", is(80))))
        .andExpect(model().attribute("plant", hasProperty("message", is("A umidade da planta esta dentro da faixa ideal"))))
        .andExpect(model().attribute("plant", hasProperty("sensor", is(TEST_PLANT_ID))))
        .andExpect(view().name("plants/plantsDetails"));
	}
	
}
