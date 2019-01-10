package com.microservice_weather_basic.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice_weather_basic.pojo.WeatherResponse;


/**
 * Weather Data Client.
 * 
 * @since 1.0.0 2017年11月28日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@FeignClient("weather-data-server")
public interface WeatherDataClient {
	
	@GetMapping("/weather/citydata/{city}")
	WeatherResponse getDataByCityId(@PathVariable("city") String city);
}
