package observer;

import java.util.ArrayList;
import java.util.List;

// These is the Subject
interface Subject {
	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();
}

interface Observer {
	public void update();
}

interface DisplayElement {
	public void display();
}

// These is the main subject the observer register here to receive the updates to all the subscribed observer.
class WeatherData implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	private float temperature = 0;
	private float humidity = 0;
	private float pressure = 0;

	// Register the Observer
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	// Notify all the observer which are subscribed
	@Override
	public void notifyObserver() {
		for (Observer obs : observers) {
			obs.update();
		}
	}

	// when the measurements are changed notify's all the subscriber
	public void measurementsChanged() {
		this.notifyObserver();
	}

	// Sets the measurements and displays the updates.
	public void setMeasurements(float temperature, float pressure, float humidity) {
		this.humidity = humidity;
		this.pressure = pressure;
		this.temperature = temperature;
		this.measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}

// There can be multiple displays developer can add as many display as it wants by using DisplayElement Interface
class CurrentConditionDisplay implements Observer, DisplayElement {
	private WeatherData weatherdata;

	public CurrentConditionDisplay(WeatherData weatherdata) {
		this.weatherdata = weatherdata;
		this.weatherdata.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current Condition = " + weatherdata.getHumidity() + " " + weatherdata.getPressure());
	}

	@Override
	public void update() {
		this.display();
	}

}

// lets add new display again
class ForecastDisplay implements DisplayElement, Observer {
	private WeatherData weatherdata;

	public ForecastDisplay(WeatherData weatherdata) {
		this.weatherdata = weatherdata;
		this.weatherdata.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Forecast Display = " + weatherdata.getHumidity() * 100 + " " + weatherdata.getPressure());
	}

	@Override
	public void update() {
		this.display();
	}

}

public class ObserverPattern {

	public static void main(String[] args) {
		// Creating the instance of Weather Class
		WeatherData weatherdata = new WeatherData();

		// Displaying the data from the Weather Data using Observer or Display
		CurrentConditionDisplay currcondition = new CurrentConditionDisplay(weatherdata);
		ForecastDisplay forecastdisplay = new ForecastDisplay(weatherdata);

		// Setting the measurements in the weather data
		weatherdata.setMeasurements(1, 1, 2);
		weatherdata.setMeasurements(5, 5, 5);
	}
}

/**
 * Output:
 * Current Condition = 2.0 1.0
 * Forecast Display = 200.0 1.0
 * Current Condition = 5.0 5.0
 * Forecast Display = 500.0 5.0
 */
