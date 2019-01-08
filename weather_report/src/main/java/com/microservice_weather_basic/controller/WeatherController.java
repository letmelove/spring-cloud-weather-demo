package com.microservice_weather_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice_weather_basic.pojo.WeatherResponse;
import com.microservice_weather_basic.service.WeatherDataService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherDataService weatherService;
	
	@GetMapping("/citydata/{city}")
	public WeatherResponse getWeather(@PathVariable("city")String city) {
		return weatherService.getData(city);
	}
}
