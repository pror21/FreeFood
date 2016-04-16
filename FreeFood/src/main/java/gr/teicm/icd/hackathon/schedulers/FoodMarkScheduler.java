package gr.teicm.icd.hackathon.schedulers;

import java.util.TimerTask;

import gr.teicm.icd.hackathon.models.FoodMark;
import gr.teicm.icd.hackathon.services.FoodMarkService;

public class FoodMarkScheduler extends TimerTask {
	
	private FoodMark foodmark;
	private FoodMarkService markFoodService;
	
	public FoodMarkScheduler(FoodMarkService markFoodService, FoodMark foodmark) {
		this.markFoodService = markFoodService;
		this.foodmark = foodmark;
	}
	
	@Override
	public void run() {
		markFoodService.deleteFoodMark(foodmark);
	}
}
