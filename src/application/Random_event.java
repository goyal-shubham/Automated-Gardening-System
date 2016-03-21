package application;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.*;
import controller.Controller;
import logger.MyLogger;
import plant.Plants;

public class Random_event {

	Logger myLogger = MyLogger.getLogger();

	int time = -1;
	Heater_controller heater1 = new Heater_controller();
	Sprinkler_controller sprinkler1 = new Sprinkler_controller();
	static Random myRandom = new Random();
	
	public Random_event(int time) {
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public void printDayTime(){
		System.out.println("Day " + MyTimer.getDay() +", Hour " + MyTimer.getHour());
	}

	public void randomEvent(Plants[] plants){
	//	System.out.println("Random Event called");
		//System.out.println(this.time + "SHubham");

		int current_time = MyTimer.getHour();
		if(this.time == current_time){
		//	System.out.println("Inside the loop");
			int randEvent = myRandom.nextInt(4);
		
			switch(randEvent){
			case 0:
				rain(plants);
				break;
			case 1:
				snow(plants);
				break;
			case 2:
				pest(plants);
				break;
			case 3:
				fire(plants);
				break;
			case 4:
				break;
			
			}
			
			this.setTime(myRandom.nextInt(23));
		}
		
	}
	
	public void rain(Plants[] plants){
		myLogger.log(Level.WARNING, "Its Raining!!");
		myLogger.log(Level.INFO, "All Sprinklers ON");

		System.out.println("Rain!");

		for(Plants p : plants){
			sprinkler1.sprinklerOverride(p);
		}
	}
	
	public void snow(Plants[] plants){
		myLogger.log(Level.WARNING, "Snow Storm attacked your garden!");
		System.out.println("Snow!");

		Controller.current_temp = 30;
	}
	
	public void fire(Plants[] plants){
		myLogger.log(Level.WARNING, "Fire! Fire! Fire!");
		System.out.println("Fire!");
		sprinkler1.on(plants);
		//heater1.setCurrent_temp(100);
		Controller.current_temp = 60;

	}
	
	public void pest(Plants[] plants){
		int random_plant = myRandom.nextInt(plants.length - 1);
		myLogger.log(Level.WARNING, "Pest attacked your " + plants[random_plant].getName());
		System.out.println("Pest!");

		Pesticide_controller pesticide1 = new Pesticide_controller();
		pesticide1.on(plants[random_plant]);
		
	}
	
}
