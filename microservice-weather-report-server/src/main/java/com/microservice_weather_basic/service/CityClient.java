package com.microservice_weather_basic.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservice_weather_basic.pojo.City;


/**
 * City Client.
 * 
 * @since 1.0.0 2017年11月28日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@FeignClient("weather-city-server")
public interface CityClient {
	
	@GetMapping("/citys")
	List<City> listCity() throws Exception;
}
