package com.microservice_weather_basic.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice_weather_basic.pojo.City;
import com.microservice_weather_basic.pojo.WeatherResponse;
import com.microservice_weather_basic.service.impl.DataClientFallback;

/**
 * 获取城市数据和天气数据
 * @author tangxiao
 *
 */
@FeignClient(name="weather-zuul",fallback=DataClientFallback.class)
public interface DataClient {
	/**
	 * 获取城市列表
	 * @return
	 */
	@GetMapping("/city/citys")
	List<City> listCity();
	/**
	 * 根据城市id查询天气数据
	 * @param city
	 * @return
	 */
	@GetMapping("/data/weather/citydata/{city}")
	WeatherResponse getDataByCityId(@PathVariable("city")String city) ;
}
