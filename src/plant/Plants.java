package plant;

import java.util.logging.Level;
import java.util.logging.Logger;

import logger.MyLogger;
import application.MyTimer;

abstract public class Plants {
	
	Logger myLogger = MyLogger.getLogger();
	
	String name;
	int age;
	double current_age;
	int MaxTemp_level;
	int MinTemp_level;
	int water_level;
	int fertilizer_level;
	int time_for_watering;
	int last_watering_time;
	int days_for_fertilizer;
	int last_fertilizer_day;
	
	public Plants(String name,int age, int MaxTemp_level, int MinTemp_level, int fertilizer_level, int water_level, int time_for_watering,int last_watering_time,int days_for_fertilizer, int last_fertilizer_day) {
		super();
		this.days_for_fertilizer = days_for_fertilizer;
		this.name = name;
		this.age = age;
		this.MaxTemp_level = MaxTemp_level;
		this.MinTemp_level = MinTemp_level;
		this.fertilizer_level = fertilizer_level;
		this.water_level = water_level;
		this.time_for_watering = time_for_watering;
		this.last_watering_time = last_watering_time;
		this.last_fertilizer_day = last_fertilizer_day;
		this.current_age = 0;
	}
	
	public int getLast_fertilizer_day() {
		return last_fertilizer_day;
	}

	public void setLast_fertilizer_day(int last_fertilizer_day) {
		this.last_fertilizer_day = last_fertilizer_day;
	}
	
	public int getDays_for_fertilizer() {
		return days_for_fertilizer;
	}

	public void setDays_for_fertilizer(int days_for_fertilizer) {
		myLogger.log(Level.INFO, "Fertilizer need increased for " + this.getName());
		this.days_for_fertilizer = days_for_fertilizer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPlant_type(String plant_type) {
		this.name = plant_type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public double getCurrent_age() {
		return current_age;
	}

	public void setCurrent_age(double current_age) {
		if(this.getCurrent_age() <= 100){
			//String result = String.format("%42", current_age);
			//int result1 = Integer.parseInt(result);

			myLogger.log(Level.FINE,"Age of " + this.name + " increased to " + (current_age < 100 ? (Math.round(current_age*100.0)/100.0) : 100 ));
			if(this.getCurrent_age() >= 100){
				myLogger.log(Level.FINE, this.name + " is fully grown");
			}
		}
		
		
		
		this.current_age = current_age;
	}

	public int getMaxTemp_level() {
		return MaxTemp_level;
	}

	public void setMaxTemp_level(int MaxTemp_level) {
		myLogger.log(Level.FINE, "Max Temp level has been adjusted for " + this.name);
		this.MaxTemp_level = MaxTemp_level;
	}
	public int getMinTemp_level() {
		return MinTemp_level;
	}

	public void setMinTemp_level(int MinTemp_level) {
		myLogger.log(Level.FINE, "Min Temp level has been adjusted for " + this.name);
		this.MinTemp_level = MinTemp_level;
	}
	
	

	public int getFertilizer_level() {
		return fertilizer_level;
	}

	public void setFertilizer_level(int fertilizer_level) {
		//myLogger.log(Level.FINE, "Fertilizer given to plant " + this.name);
		this.fertilizer_level = fertilizer_level;
	}

	public int getWater_level() {
		return water_level;
	}

	public void setWater_level(int water_level) {
		System.out.println("Current Water level " + this.name + " is " + getWater_level());
		this.water_level = water_level;
	}

	public int getTime_for_watering() {
		return time_for_watering;
	}

	public void setTime_for_watering(int time_for_watering) {
		this.time_for_watering = time_for_watering;
	}

	public int getLast_watering_time() {
		return last_watering_time;
	}

	public void setLast_watering_time(int last_watering_time) {
		this.last_watering_time = last_watering_time;
	}

	
	
// To implement the growth of plant
	public void growthPlan(){
		System.out.println("Growth plan is called");
		double a = (double) this.getAge() * 24;
		double b = MyTimer.getTotalHour();
		double c = (100 / a );
		double d = (b - this.getLast_watering_time() ) * c;
		//System.out.println(a + " " + b + " " + c + " " + d + " " + this.getCurrent_age());
		if(b != this.getLast_watering_time()){
			if(this.getCurrent_age() < 50){
				
				this.setCurrent_age(this.getCurrent_age() + d);
			}
			else if(this.getCurrent_age() == 50){
				this.setMaxTemp_level(getMaxTemp_level() + 5);
				this.setMaxTemp_level(getMaxTemp_level() - 5);
				int f = this.getFertilizer_level() - 1 ;
				this.setDays_for_fertilizer(f == 0 ? 1 : f );
			}
			else
			{
				this.setCurrent_age(this.getCurrent_age() + d - 1);
			}
		}
		
	}
	
}
