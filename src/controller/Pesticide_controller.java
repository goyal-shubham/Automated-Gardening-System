package controller;

import java.util.logging.Level;

import plant.*;

public class Pesticide_controller extends Controller{

	public void on(Plants p){
		//System.out.println("Pesticide given");
		myLogger.log(Level.INFO, "Pesticide Override for " + p.getName());
		
	}

}
