package com.microservice_weather_basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice_weather_basic.pojo.City;
import com.microservice_weather_basic.service.CityDataService;

@RestController
public class CityController {
	@Autowired
	private CityDataService cityService;
	@GetMapping("/citys")
	public List<City> lisyCity() throws Exception{
		return cityService.listCity();
	}
}
