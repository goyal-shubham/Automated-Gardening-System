package controller;

import java.util.Random;

import application.MyTimer;

public class Temperature_controller extends Controller {
	
	int set_time = 0;
	
	public int getSet_time() {
		return set_time;
	}
	
	public void setSet_time(int set_time) {
		this.set_time = set_time;
	}

	public void changeTemp(){
		
		int current_time = MyTimer.getHour();
	
		if(current_time - set_time >= 1 || current_time - set_time == -23){
			Random rand = new Random();
			int diff = rand.nextInt(3);
			if (current_time <= 5 || current_time >= 18){
				//int temp = getCurrent_temp();		
					setCurrent_temp(getCurrent_temp() - diff);				
			}
			else{
				//int temp = getCurrent_temp();
				setCurrent_temp(getCurrent_temp() + diff);				
			}
			System.out.println("temp " + getCurrent_temp());
			//System.out.println(current_time);
			setSet_time(current_time);
			//myLogger.log(Level.INFO, "Current Temperature " + current_temp);

		}
		
	}
}
