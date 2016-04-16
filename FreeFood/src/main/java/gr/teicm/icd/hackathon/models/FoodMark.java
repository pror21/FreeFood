package gr.teicm.icd.hackathon.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "foodmarks")
public class FoodMark {
	
	public enum Time {
		S1, H1, H2, H3, H4, H5, D1, D2, D3, D4, D5, PERMAPPL, PERMANENT;
	}
	
	@Id private String id;
	private Account acc;
	private String food;
	private String info;
	private Time time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
}