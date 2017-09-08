package com.weatherapp.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.weatherapp.dto.WeatherDetails;
import com.weatherapp.weatherservice.WeatherAppService;

@Controller
public class WeatherAppController {
		
		/* URL provided by Amazon to retrieve external IP Address for any client browser */
		private static String GET_IP_ADDRESS = "http://checkip.amazonaws.com/";
	
		@Autowired
		WeatherAppService weatherService;
		
		@Autowired
		ResourceLoader resourceLoader;
		
		/* Using open library - GeoLite*/
		LookupService lookupService;
		
		WeatherDetails responseObj = new WeatherDetails();
		
		@RequestMapping("/")
		public String homePage(Map<Object, Object> model) {
			try {
				
				/* Using open library - GeoLite to retrieve further details from IP Address */
				//Resource resource = resourceLoader.getResource("GeoLiteCity.dat");
				//File file = resource.getFile();
				FileSystemResource rs = new FileSystemResource("GeoLiteCity.dat");
				File file = rs.getFile();
				lookupService = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE | LookupService.GEOIP_CHECK_CACHE);
				Location location = lookupService.getLocation(getIPAddress());
				
				/* Service call to particular method */
				HashMap<String, Object> result = weatherService.getWeatherForCity(location.city);
				
				/* Populating the response object with results from API response */
				responseObj.setCityname((String) result.get("Name"));
				responseObj.setDescription((String) result.get("Description"));
				responseObj.setWeatherCondition((String) result.get("MainCondition"));
				responseObj.setTemperature((Long) result.get("Temperature"));
				responseObj.setTemperatureMin((Long) result.get("TemperatureMin"));
				responseObj.setTemperatureMax((Long) result.get("TemperatureMax"));
				responseObj.setHumidity((String) result.get("Humidity"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/* Populating the model with the response bean */
			model.put("response", responseObj);
			
			/*Returning the view corresponding to our method call*/
			return "home";
		}
		
		/* Function to retrieve external IP Address for client browser */
		private String getIPAddress() throws Exception{
			URL connection = new URL(GET_IP_ADDRESS);
		    URLConnection con = connection.openConnection();
		    String ipaddress = null;
		    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    ipaddress = reader.readLine();
		    return ipaddress;
		}
}