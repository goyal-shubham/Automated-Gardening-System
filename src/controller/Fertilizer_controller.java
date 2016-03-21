package controller;

import java.util.logging.Level;

import application.MyTimer;
import plant.*;

public class Fertilizer_controller extends Controller{
	
	
	
	public void on(Plants p){
		myLogger.log(Level.INFO, "Fertilizer Override for " + p.getName());
		System.out.println("fertilizng" + p.getName());
	}
	
	public void off(Plants p){
		
	}
	
	
	public void fertilizer_regulator(Plants p){
		
		int t = MyTimer.getDay();
		if(t - p.getLast_fertilizer_day() == p.getDays_for_fertilizer() ){
			
			myLogger.log(Level.FINE, "Fertilizing plant " + p.getName());
			//System.out.println("day is " + t);
			p.setFertilizer_level(100);
			p.setLast_fertilizer_day(t);
		}
		
		if(p.getFertilizer_level() < 40){
			
			p.setFertilizer_level(80);
		
		}
	}
}
