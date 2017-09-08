package com.weatherapp.weatherservice;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherAppService {
	
	/* API call signature to retrieve weather using one GET parameter */
	private static String API_BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
	
	private static String API_KEY = "&APPID=85f8a95022d1e407e0672d70ef7c5608";
	
	/* Method to retrieve weather given the city name */
	public HashMap<String, Object> getWeatherForCity(String city){
		HashMap<String, Object> result = new HashMap<String, Object>();
		RestTemplate rest = new RestTemplate();
		String response;
			
		/* Creating request url for API Call */
		String url = API_BASE_URL + city + API_KEY;
		
		/* Calling API using request url */
		response = rest.getForObject(url, String.class);
		System.out.println("response :" + response);
		
		/* Parsing API response JSON object */
        JSONObject responseObj = new JSONObject(response);
       
        Long temp = responseObj.getJSONObject("main").getLong("temp");
        result.put("Temperature", temp);
        
        Long tempMin = responseObj.getJSONObject("main").getLong("temp_min");
        result.put("TemperatureMin", tempMin);
        
        Long tempMax = responseObj.getJSONObject("main").getLong("temp_max");
        result.put("TemperatureMax", tempMax);
        
        String humidity = String.valueOf(responseObj.getJSONObject("main").getInt("humidity"));
        result.put("Humidity", humidity);
       
        JSONArray arr = responseObj.getJSONArray("weather");
        for (int i = 0; i < arr.length(); i++)
        {
            String mainWeather = arr.getJSONObject(i).getString("main");
            result.put("MainCondition", mainWeather);
            
            String description = arr.getJSONObject(i).getString("description");
            result.put("Description", description);
        }
        
        String name = responseObj.getString("name");
        result.put("Name", name);
        
        /* Returning map of the weather details values */
        return result;
	}
}
