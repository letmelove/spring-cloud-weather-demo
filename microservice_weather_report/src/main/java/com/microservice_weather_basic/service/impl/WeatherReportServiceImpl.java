package com.microservice_weather_basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice_weather_basic.pojo.Weather;
import com.microservice_weather_basic.pojo.WeatherResponse;
import com.microservice_weather_basic.service.WeatherDataService;
import com.microservice_weather_basic.service.WeatherReportService;
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private WeatherDataService weatherService;
	@Override
	public Weather getDataByCity(String city) {
		WeatherResponse wr = weatherService.getData(city);
		return wr.getData();
	}

}
