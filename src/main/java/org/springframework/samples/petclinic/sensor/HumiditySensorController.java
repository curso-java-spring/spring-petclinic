package org.springframework.samples.petclinic.sensor;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.samples.petclinic.plant.Plant;
import org.springframework.samples.petclinic.plant.PlantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HumiditySensorController {

	private static final String VIEW_CREATE_HUMIDITY_SENSOR_FORM = "sensors/createHumiditySensorForm";
	
	private final HumiditySensorRepository sensors;	
	private final PlantRepository plants;
	
	public HumiditySensorController(HumiditySensorRepository sensors,PlantRepository plants) {
		super();
		this.sensors = sensors;
		this.plants = plants;
	
	}

	@GetMapping("/sensors/new")
	public String initCreationForm(Map<String, Object> model) {
		HumiditySensor sensor = new HumiditySensor();
		model.put("sensor", sensor);
		return VIEW_CREATE_HUMIDITY_SENSOR_FORM;
	}
	
    @PostMapping("/sensors/new")
    public String processCreationForm(@Valid HumiditySensor sensor, BindingResult result) {
        if (result.hasErrors()) {
            return VIEW_CREATE_HUMIDITY_SENSOR_FORM;
        } else {
            this.sensors.save(sensor); 
            return "redirect:/sensors/" + sensor.getId(); 
        }
    }
	
	@GetMapping("/sensors")
	public String processFindForm(Model model) {
		Collection<HumiditySensor> sensorsList = sensors.findAll();
		model.addAttribute("sensors", sensorsList);
		return "sensors/sensorsList";
	}
		
	@GetMapping("/sensors/{sensorId}")
	public ModelAndView showSensor(@PathVariable("sensorId") int sensorId) {
        ModelAndView mav = new ModelAndView("sensors/sensorsDetails");
        mav.addObject(this.sensors.findById(sensorId));
        return mav;		
	}
	
    @ModelAttribute("plants")
    public Collection<Plant> populatePlants() {
        return this.plants.findPlants();
    }
}
