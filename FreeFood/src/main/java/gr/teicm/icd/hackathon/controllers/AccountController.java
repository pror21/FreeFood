package gr.teicm.icd.hackathon.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.teicm.icd.hackathon.models.Account;
import gr.teicm.icd.hackathon.models.FoodMark;
import gr.teicm.icd.hackathon.repositories.AccountRepository;
import gr.teicm.icd.hackathon.repositories.FoodMarkRepository;
import gr.teicm.icd.hackathon.services.AccountService;
import gr.teicm.icd.hackathon.services.FoodMarkService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private FoodMarkService foodMarkService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private FoodMarkRepository foodMarkRepository;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("account", new Account());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String insertAccount(@ModelAttribute Account account, Model model) {
		model.addAttribute("account", account);
		boolean registered = accountService.insertAccount(account);
		if (registered == true)
			return "registerDone";
		else
			return "registerFailed";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/donate", method = RequestMethod.GET)
	public String donate(Model model, Principal principal) {
		model.addAttribute("foodmark", new FoodMark());
		Account account = accountRepository.findByUsername(principal.getName());
		FoodMark foodMark = foodMarkRepository.findByAccId(account.getId());
		
		if (foodMark != null) {
			return "redirect:listing";
		}
		else {
			model.addAttribute("user", account);
			return "donate";
		}
	}

	@RequestMapping(value = "/donate", method = RequestMethod.POST)
	public String insertDonate(@ModelAttribute FoodMark foodmark, Model model) {
		model.addAttribute("foodmark", foodmark);
		boolean inserted = foodMarkService.insertFoodMark(foodmark);
		if (inserted == true)
			return "listingDone";
		else
			return "listingFailed";
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
	public String listing(Model model, Principal principal) {
		Account account = new Account();
		account = accountRepository.findByUsername(principal.getName());
		FoodMark foodmark = new FoodMark();
		foodmark = foodMarkRepository.findByAccId(account.getId());
		model.addAttribute("foodmark", foodmark);
		return "listing";
	}
	
	@RequestMapping(value = "/listing", method = RequestMethod.POST)
	public String listingUpdate(@ModelAttribute FoodMark foodmark) {
		foodMarkService.updateFoodMarkListing(foodmark);
		return "redirect:/";
	}
}
