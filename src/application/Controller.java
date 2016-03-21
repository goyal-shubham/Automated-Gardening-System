package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.Random_event;
import controller.Fertilizer_controller;
import controller.Heater_controller;
import controller.Moisture_controller;
import controller.Pesticide_controller;
import controller.Sprinkler_controller;
import controller.Temperature_controller;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import logger.MyLogger;
import plant.Apple;
import plant.Lemon;
import plant.Orange;
import plant.Plants;
import plant.Rose;
import plant.Tomato;
import plant.Tulip;

public class Controller extends Thread implements Initializable {

	Plants[] myPlants = new Plants[6];
	Pesticide_controller pesticide1 = new Pesticide_controller();
	Sprinkler_controller sprinkler1 = new Sprinkler_controller();
	Fertilizer_controller fertilizer1 = new Fertilizer_controller();
	Heater_controller heater1 = new Heater_controller();
	Moisture_controller moisture1 = new Moisture_controller();
	Temperature_controller temperature1 = new Temperature_controller();
	public Thread cthread;
	public int timeElapsed;
	Logger myLogger = MyLogger.getLogger();

	@FXML
	public Label timeLabel;
	
	@FXML
	public Label dayLabel;
	
	@FXML
	public Label tempLabel;
	
	@FXML
	public Label secLabel;
	
	@Override
	public void run() {
		int t = rand.nextInt(23);
		Random_event event = new Random_event(t);
		try {
			System.out.println("System Started..");
			myLogger.log(Level.CONFIG, "System Started");
			myLogger.log(Level.CONFIG, "Planting Done");
			while (true) {
				int currentTemp = temperature1.getCurrent_temp();
				//System.out.println(currentTemp);
				String time =""+ MyTimer.getHour();
				
				
					this.UIupdate(() -> { timeLabel.setText(time);	});
					this.UIupdate(() -> { dayLabel.setText(""+MyTimer.getDay());	});
					this.UIupdate(() -> { tempLabel.setText(currentTemp + "");	});
					this.UIupdate(() -> { secLabel.setText("" + MyTimer.getSec());	});

				//System.out.println(time);
				startGarden();
				event.randomEvent(myPlants);

				Thread.sleep(1000);


			}

		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		
	
	
	private void UIupdate(Runnable updater) {
		if (updater == null)
			throw new IllegalArgumentException("runnable thread is null");
		if (Platform.isFxApplicationThread())
			updater.run();
		else
			Platform.runLater(updater);
	}

	public void start(){
		if(this.cthread == null){
			this.cthread = new Thread(this, "MyTimerThread");
			this.cthread.start();
		}
	}
	
//	@Override
//	public void run() {
//		startGarden();
//	}
	
	@FXML
	public void systemStart(){
		start();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//String name,int age, int MaxTemp_level, int MinTemp_level, int fertilizer_level, int water_level, int time_for_watering,int last_watering_time,int days_for_fertilizer, int last_fertilizer_day) {
		System.out.println("View is now loaded!");
		Plants rose = new Rose	("Rose",10, 25, 45, 80, 70, 10, 0, 2, 0);
		Plants tulip = new Tulip	("Tulip",25, 30, 60, 60, 40, 8, 0, 3, 0);
		Plants tomato= new Tomato("Tomato",35, 35, 40, 70, 70, 14, 0, 7, 0);
		Plants Lemon  = new Lemon	("Lemon", 5, 40, 50, 90, 80, 18, 0, 4, 0);
		Plants orange  = new Orange("Orange",55, 35, 50, 40, 30, 5, 0, 5, 0);
		Plants apple = new Apple	("Apple",20, 30, 60, 50, 40, 20, 0, 6, 0);
		myPlants[0] = rose;
		myPlants[1] = tulip;
		myPlants[2] = tomato;
		myPlants[3] = Lemon;
		myPlants[4] = orange;
		myPlants[5] = apple;
		temperature1.setCurrent_temp(50);
	}
	
	@FXML
	public Button startButton;
    
    @FXML
    public ComboBox<String> fertilizerOptions;
    
    @FXML
    public ComboBox<String> pesticideOptions;
    
    
    public static String replaceValue1 = " ";
    
    public static String replaceValue2 = " ";
    
    @FXML
    public Button submitFertilizer;
    
    @FXML
    public Button submitPesticide;

    @FXML
    public void giveFertilizer(){
    	
    	System.out.println("Fertilizer");
    	
    	fertilizerOptions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

    		@Override
    		public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
    			// TODO Auto-generated method stub
    			
    			replaceValue2 = newValue.toString();

    		}
    		
    	});
    	
    	int index = 0;
    	System.out.println(replaceValue2);
    	//System.out.println("I am here");
    	switch(replaceValue2){
    	
   
    	case "Rose": 
    		//System.out.println("in rose swtich");
    		index = 0;
    		break;
    	case "Tulip": 
    		index = 1;
    		break;
    	case "Tomato":
    		index = 2;
    		break;
    	case "Lemon": 
    		index = 3;
    		break;
    	case "Orange": 
    		index = 4;
    		break;
    	case "Apple": 
    		index = 5;
    		break;
    	default :
			break;
    	}
    		
    	fertilizer1.on(myPlants[index]);
    }

    
	public void givePesticide(){
		
		System.out.println("Pesticide");

		pesticideOptions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
	
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
	
				replaceValue1 = newValue.toString();
	
			}
	
		});
	
		int index = 0;
		System.out.println(replaceValue1);
		switch(replaceValue1){
    	
		   
    	case "Rose": 
    		//System.out.println("in rose swtich");
    		index = 0;
    		break;
    	case "Tulip": 
    		index = 1;
    		break;
    	case "Tomato":
    		index = 2;
    		break;
    	case "Lemon": 
    		index = 3;
    		break;
    	case "Orange": 
    		index = 4;
    		break;
    	case "Apple": 
    		index = 5;
    		break;
    	default :
    			break;
    	}
		System.out.println(index);
		pesticide1.on(myPlants[index]);
	}

	
	Random rand = new Random();
	
	double time = 1;

	
	public void startGarden() {
		
		

		//System.out.println("System Started");
		//System.out.println(MyTimer.getTotalHour());

	//while (true) {
			
			double currentTime1 = MyTimer.getTotalHour();
			if (time == currentTime1) {
				
				System.out.println(MyTimer.getTotalHour());

		
				for (Plants p : myPlants) {

					sprinkler1.giveWater(p);// checked
					fertilizer1.fertilizer_regulator(p); // checked
					moisture1.moistureController(p); // checked
					heater1.heaterController(p);
				}

			//	event.randomEvent(myPlants);
				temperature1.changeTemp(); // checked
				
				time++;
			}
		
	}
	
	
	
	@FXML
	public Button Rose;

	public void giveWaterRose() {
		
		System.out.println("Water override");
		sprinkler1.sprinklerOverride(myPlants[0]);

	}
	
	@FXML
	public Button Tulip;

	public void giveWaterTulip() {
		
		System.out.println("Water override");
		sprinkler1.sprinklerOverride(myPlants[1]);

	}
	
	@FXML
	public Button Orange;

	public void giveWaterOrange() {

		System.out.println("Water override");
		sprinkler1.sprinklerOverride(myPlants[4]);

	}
	
	@FXML
	public Button Lemon;
	
	
	public void giveWaterLemon() {

		System.out.println("Water override");
		sprinkler1.sprinklerOverride(myPlants[3]);
	}
	
	@FXML
	public Button Apple;
	
	@FXML
	public void giveWaterApple() {
		
		System.out.println("Water override");
		sprinkler1.sprinklerOverride(myPlants[5]);

	}
	
	@FXML
	public Button Tomato;
	
	@FXML
	public void giveWaterTomato() {
		System.out.println("Water override");
		sprinkler1.sprinklerOverride(myPlants[2]);

	}
	
	@FXML
	public ComboBox<String> randomEvent;
	
	@FXML
	public Button submitRandom;
	
	public static String randomVal = " ";
	
	
	public void doRandomEvent(){
		Random_event E = new Random_event(-1);
    	//int index = 0;
    	System.out.println(randomVal);
    	//System.out.println("I am here");
    	switch(randomVal){
    	
   
    	case "Rain": 
    		E.rain(myPlants);
    		break;
    	case "Pest": 
    		E.pest(myPlants);
    		break;
    	case "Snow Storm":
    		E.snow(myPlants);
    		break;
    	case "Fire": 
    		E.fire(myPlants);
    		break;
    	default :
    		break;
    	}
		
	}
	@FXML
    public void getRandomEvent(){
    	
    	
		System.out.println("Random Event");
    	
		randomEvent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

    		@Override
    		public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
    			// TODO Auto-generated method stub
    			
    			randomVal = newValue.toString();

    		}
    		
    	});
    	  
		doRandomEvent();
    	
	}

}
