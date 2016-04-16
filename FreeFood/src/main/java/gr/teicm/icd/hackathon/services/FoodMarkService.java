package gr.teicm.icd.hackathon.services;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import gr.teicm.icd.hackathon.models.Account;
import gr.teicm.icd.hackathon.models.FoodMark;
import gr.teicm.icd.hackathon.repositories.AccountRepository;
import gr.teicm.icd.hackathon.repositories.FoodMarkRepository;
import gr.teicm.icd.hackathon.schedulers.FoodMarkScheduler;

@Service
public class FoodMarkService {

	@Autowired
	private FoodMarkRepository foodMarkRepository;
	
	@Autowired
	private AccountRepository repository;

	@Autowired
	private SimpMessagingTemplate template;
	
	public FoodMarkService() {

	}
	
	public boolean insertFoodMark(FoodMark foodmark) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account account = new Account();
		account = repository.findByUsername(auth.getName());

		if(foodMarkRepository.findByAcc(account) == null) { 
			foodmark.setAcc(account);
			foodMarkRepository.insert(foodmark);
			this.template.convertAndSend("/markers", foodmark);
			assignScheduler(foodmark);
			return true;
		}
		else
			return false;
	}
	
	public void assignScheduler(FoodMark foodmark) {
		Timer timer = new Timer();
		TimerTask timerTask = new FoodMarkScheduler(this, foodmark);
		switch (foodmark.getTime()) {
		case S1:
			timer.schedule(timerTask, 10000);
			break;
		case H1:
			timer.schedule(timerTask, TimeUnit.HOURS.toMillis(1));
			break;
		case H2:
			timer.schedule(timerTask, TimeUnit.HOURS.toMillis(2));
			break;
		case H3:
			timer.schedule(timerTask, TimeUnit.HOURS.toMillis(3));
			break;
		case H4:
			timer.schedule(timerTask, TimeUnit.HOURS.toMillis(4));
			break;
		case H5:
			timer.schedule(timerTask, TimeUnit.HOURS.toMillis(5));
			break;
		case D1:
			timer.schedule(timerTask, TimeUnit.DAYS.toMillis(1));
			break;
		case D2:
			timer.schedule(timerTask, TimeUnit.DAYS.toMillis(2));
			break;
		case D3:
			timer.schedule(timerTask, TimeUnit.DAYS.toMillis(3));
			break;
		case D4:
			timer.schedule(timerTask, TimeUnit.DAYS.toMillis(4));
			break;
		case D5:
			timer.schedule(timerTask, TimeUnit.DAYS.toMillis(5));
			break;
		case PERMAPPL:
			break;
		case PERMANENT:
			break;
		}
	}

	public void deleteFoodMark(FoodMark foodmark) {
		foodMarkRepository.delete(foodmark);
		this.template.convertAndSend("/removeMarker", foodmark.getId());
	}
	
	public List<FoodMark> getAllFoodMarks() {
		return foodMarkRepository.findAll();
	}
}