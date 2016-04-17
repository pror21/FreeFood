package gr.teicm.icd.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.teicm.icd.hackathon.services.FoodMarkService;

@Controller
public class HomeController {
	
	@Autowired
	private FoodMarkService foodMarkService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("allFoodMarks", foodMarkService.getAllFoodMarks());
		return "index";
	}
}
