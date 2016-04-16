package gr.teicm.icd.hackathon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.teicm.icd.hackathon.models.Account;
import gr.teicm.icd.hackathon.models.FoodMark;

@Controller
public class AccountController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("account", new Account());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String insertAccount(@ModelAttribute Account account, Model model) {
		return "registerDone";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/donate", method = RequestMethod.GET)
	public String donate(Model model) {
		model.addAttribute("foodmark", new FoodMark());
		return "donate";
	}

	@RequestMapping(value = "/donate", method = RequestMethod.POST)
	public String insertDonate(@ModelAttribute FoodMark foodmark, Model model) {
		return "insertDone";
	}

	@RequestMapping(value = "/listingDone", method = RequestMethod.GET)
	public String insertDone() {
		return "listingDone";
	}

	@RequestMapping(value = "/listingFailed", method = RequestMethod.GET)
	public String insertFailed() {
		return "listingFailed";
	}

	@RequestMapping(value = "/registerDone", method = RequestMethod.GET)
	public String registerDone() {
		return "registerDone";
	}

	@RequestMapping(value = "/registerFailed", method = RequestMethod.GET)
	public String registerFailed() {
		return "registerFailed";
	}

	@RequestMapping(value = "/listing", method = RequestMethod.GET)
	public String listing() {
		return "listing";
	}
}
