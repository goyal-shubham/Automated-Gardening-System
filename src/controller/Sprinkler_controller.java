package controller;
import java.util.logging.Level;
import java.util.logging.Logger;

import logger.MyLogger;
import application.MyTimer;
import plant.Plants;

public class Sprinkler_controller	{
	
	Logger mylogger = MyLogger.getLogger();
	
	public void on(Plants[] plants){
		System.out.println("ALl sprinklers on");
		for(Plants p : plants){
			sprinklerOverride(p);
		}
	}
	
	public void giveWater(Plants p)	{
		int t = MyTimer.getHour();
		int t1;
		//System.out.println();
		if(t == 0){
			t1 = 24;
		}
		else{
			t1 = t + (24 * (MyTimer.getDay()-1));
		}
		if(p.getTime_for_watering() == t1 - p.getLast_watering_time())   {
			
			//System.out.println(p.getLast_watering_time() + " " + p.getTime_for_watering() + " " + t1);
			//System.out.println("Watering plant " + p.name);
			//System.out.println("yes");
			System.out.println("Sprinkler is ON for " + p.getName() );
			mylogger.log(Level.FINE, "Sprinkler is ON for " + p.getName() );
			p.setWater_level(100);
			//System.out.println(t);
			p.growthPlan();
			p.setLast_watering_time(t1);

		}
	}
	
	public void sprinklerOverride(Plants p){
		int t = MyTimer.getHour();
		int t1;
		//System.out.println();
		if(t == 0 && MyTimer.getDay() != 1){
			t1 = 24;
		}
		else{
			t1 = t + (24 * (MyTimer.getDay()-1));
		}
		p.setWater_level(100);
		mylogger.log(Level.INFO, "Sprinkler Override " + p.getName());
		//mylogger.log(Level.FINE, "Watering " + p.getName() );
		p.growthPlan();
		p.setLast_watering_time(t1);
	}
	
}
