package com.microservice_weather_basic.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.microservice_weather_basic.pojo.City;

/**
 * 通过城市微服务获取城市列表
 * @author tangxiao
 *
 */
@FeignClient("weather-city-server")
public interface CityClient {
	@GetMapping("/citys")
	List<City> listCity();
}
