package controller;
import java.util.logging.Level;

import application.MyTimer;
import plant.*;

public class Heater_controller extends Controller{
	
	int set_day;
	
	public Heater_controller() {
		set_day = 0;
	}
	
/*	Sprinkler_controller sprinkler = new Sprinkler_controller();
	
	public void on(Plants p){
		
	}
	
	public void off(Plants p){
		
	}
	
	public Heater_controller() {
		current_temp = 20;
		set_time = 0;
	}

	

	public Sprinkler_controller getSprinkler() {
		return sprinkler;
	}

	public void setSprinkler(Sprinkler_controller sprinkler) {
		this.sprinkler = sprinkler;
	}
	
	
	
	public void checkTemp(Plants p){
		int temp = p.getTemp_level();
		int current_temp = Controller.getCurrent_temp();
		if( current_temp > temp){
			sprinkler.giveWater(p);
		}
		else if(current_temp < temp){
			System.out.println("heater is ON");
			setCurrent_temp(temp);
		}
	}*/
	
	public void on(){
		
		myLogger.log(Level.INFO, "Heater of garden is ON");
		while(getCurrent_temp() < 50){
			increaseTemp();
		}
	}
	
	public void on(Plants p){
		
		myLogger.log(Level.INFO, "Heater is ON for " + p.getName() );
		
	}
	
	public void off(Plants p){
		
		myLogger.log(Level.INFO, "Cooler is Off for " + p.getName() );
		
	}
	
	public void off(){
		myLogger.log(Level.INFO, "Cooler of garden is ON");

		while(getCurrent_temp() > 50){
			decreaseTemp();
		}
	}
	
	
	public void heaterController(Plants p){
		int current_day = MyTimer.getDay();
		if(current_day - set_day == 1 ){
			{
				if(p.getMaxTemp_level() < current_temp){
					myLogger.log(Level.WARNING, "Too cold for " + p.getName() );
					this.on(p);

				}
				else if(p.getMinTemp_level() > current_temp){
					myLogger.log(Level.WARNING, "Too hot for " + p.getName() );
					this.off(p);
				}
				set_day = current_day;
			}
	}
	}
		
}
