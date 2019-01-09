package com.microservice_weather_basic.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice_weather_basic.pojo.WeatherResponse;
/**
 * 通过天气数据微服务获取天气数据
 * @author tangxiao
 *
 */
@FeignClient("weather-data-server")
public interface WeatherDataClient {
	@GetMapping("weather/citydata/{city}")
	WeatherResponse getWeatherByCityId(@PathVariable(name="city")String city);
}
