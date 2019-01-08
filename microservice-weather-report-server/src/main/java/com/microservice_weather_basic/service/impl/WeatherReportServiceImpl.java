package com.microservice_weather_basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice_weather_basic.pojo.Forecast;
import com.microservice_weather_basic.pojo.Weather;
import com.microservice_weather_basic.service.WeatherReportService;
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Override
	public Weather getDataByCity(String city) {
		Weather data = new Weather();
		data.setAqi("81");
		data.setCity("深圳");
		data.setGanmao("易感冒");
		data.setWendu("10");
		
		List<Forecast> forecastList = new ArrayList<>();
		Forecast forecast = new Forecast();
		forecast.setDate("9日星期三");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温11度");
		forecast.setLow("低温5度");
		forecastList.add(forecast);
		
		forecast = new Forecast();
		forecast.setDate("10日星期四");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温11度");
		forecast.setLow("低温5度");
		forecastList.add(forecast);
		
		forecast = new Forecast();
		forecast.setDate("11日星期五");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温11度");
		forecast.setLow("低温5度");
		forecastList.add(forecast);
		
		forecast = new Forecast();
		forecast.setDate("12日星期六");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温11度");
		forecast.setLow("低温5度");
		forecastList.add(forecast);
		
		forecast = new Forecast();
		forecast.setDate("9日星期日");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温11度");
		forecast.setLow("低温5度");
		forecastList.add(forecast);
		
		data.setForecast(forecastList);
		
		return data;
	}

}
