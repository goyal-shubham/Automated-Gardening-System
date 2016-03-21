package plant;

import plant.Vegetables;

public class Lemon extends Vegetables {
	
	public Lemon(String name,int age, int maxtemp_level,int mintemp_level,int fertilizer_level, int water_level, int time_for_watering,int last_watering_time,int days_for_fertilizer, int last_fertilizer_day){
		super(name,age,maxtemp_level,mintemp_level,fertilizer_level,water_level, time_for_watering,last_watering_time,days_for_fertilizer, last_fertilizer_day);
	}
	
	
//	public void growthPlan(){
//
//		if(age <= 50){
//			setAge(getAge() + 5);
//			setFertilizer_level(getFertilizer_level() - 5) ;
//		}
//		else if (age <= 95){
//			setAge(getAge() + 3);
//			setFertilizer_level(getFertilizer_level() - 5) ;
//			//System.out.println(this.age);
//		}
//		else{
//			setFertilizer_level(getFertilizer_level() - 1) ;
//			if(this.age == 100){
//				//setAge(getAge() + 1);
//				//System.out.println(super.name + " is fully grown");
//				return;
//			}
//			setAge(getAge() + 1);
//		}
//		
//	}
}
