package org.springframework.samples.petclinic.plant;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
class PlantController {
	private final PlantRepository plants;
	
	public PlantController(PlantRepository plants) {
		super();
		this.plants = plants;
	}

	@GetMapping("/plants")
	public String processFindForm(Model model) {
		Collection<Plant> plantsList = plants.findAll();
		model.addAttribute("plants", plantsList);
		return "plants/plantsList";
	}
	
	
	@GetMapping("/plants/{plantId}")
	public ModelAndView showPlant(@PathVariable("plantId") int plantId) {
        ModelAndView mav = new ModelAndView("plants/plantsDetails");
        mav.addObject(this.plants.findById(plantId));
        return mav;        
	}
	

}