package controller;
import java.util.Random;
import java.util.logging.Level;

import application.MyTimer;
import plant.Plants;

public class Moisture_controller extends Controller{
	
	int set_time;
	
	public int getSet_time() {
		return set_time;
	}

	public void setSet_time(int set_time) {
		this.set_time = set_time;
	}

	public void moistureController(Plants p){
		int current_time = MyTimer.getHour();
		Sprinkler_controller sprinkler1 = new Sprinkler_controller();
		Random r = new Random();
		int diff = r.nextInt(10);
		if(current_time - set_time >= 1 || current_time - set_time == -23){
			System.out.println(current_time);
			p.setWater_level(p.getWater_level() - diff);
			setSet_time(current_time);
			
		}
		
		if(p.getWater_level() <= 20){
			myLogger.log(Level.WARNING, p.getName() + " Moisture is very low.");
			sprinkler1.sprinklerOverride(p);
		}
	}
	
}
