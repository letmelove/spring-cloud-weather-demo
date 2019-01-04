package com.microservice_weather_basic.service.impl;

import com.microservice_weather_basic.pojo.WeatherResponse;
import com.microservice_weather_basic.service.WeatherDataService;

public class WeatherDataServiceImpl implements WeatherDataService {
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	private String uri;
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		uri = WEATHER_URI + "citykey=" + cityId;
		return null;
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		uri = WEATHER_URI + "city=" + cityName;
		return null;
	}

}
