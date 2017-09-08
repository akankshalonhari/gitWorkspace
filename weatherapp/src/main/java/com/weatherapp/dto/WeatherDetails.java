package com.weatherapp.dto;

/* Data transfer Bean to hold the retrieved values from API Response  */
public class WeatherDetails {

	String cityname;
	String weatherCondition;
	String description;
	Long temperature;
	Long temperatureMin;
	Long temperatureMax;
	String humidity;
	
	
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	public String getWeatherCondition() {
		return weatherCondition;
	}
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getTemperature() {
		return temperature;
	}
	public void setTemperature(Long temperature) {
		this.temperature = temperature;
	}
	
	public Long getTemperatureMin() {
		return temperatureMin;
	}
	public void setTemperatureMin(Long temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	public Long getTemperatureMax() {
		return temperatureMax;
	}
	public void setTemperatureMax(Long temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
}