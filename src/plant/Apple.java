package plant;

import plant.Fruits;

public class Apple extends Fruits {
	
	public Apple(String name,int age, int maxtemp_level,int mintemp_level,int fertilizer_level, int water_level, int time_for_watering,int last_watering_time,int days_for_fertilizer, int last_fertilizer_day){
		super(name,age,maxtemp_level,mintemp_level,fertilizer_level,water_level, time_for_watering,last_watering_time,days_for_fertilizer, last_fertilizer_day);
	}
	
}