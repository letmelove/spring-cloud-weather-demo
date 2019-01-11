package com.microservice_weather_basic.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice_weather_basic.pojo.Weather;
import com.microservice_weather_basic.pojo.WeatherResponse;
import com.microservice_weather_basic.service.DataClient;
import com.microservice_weather_basic.service.WeatherDataClient;
import com.microservice_weather_basic.service.WeatherReportService;
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private DataClient dataClient;
	
	@Autowired
	private WeatherDataClient weatherDataClient;
	@Override
	public Weather getDataByCity(String city) {
		WeatherResponse resp = dataClient.getDataByCityId(city);
		Weather weather = null;
		if(null!=resp) {
			weather=resp.getData();
		}
		return weather;
	}

}
