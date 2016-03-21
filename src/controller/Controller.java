package controller;

import java.util.logging.Logger;

import logger.MyLogger;

public abstract class Controller {
	
	public static int current_temp;
	Logger myLogger = MyLogger.getLogger();
	
	public int getCurrent_temp() {
		return current_temp;
	}

	public void setCurrent_temp(int current_temp) {
		Controller.current_temp = current_temp;
	}
	
	public void increaseTemp(){
		
		Controller.current_temp++;
	}
	
	public void decreaseTemp(){
		Controller.current_temp--;
	}
		
}
