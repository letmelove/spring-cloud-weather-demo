package com.microservice_weather_basic.service;

import com.microservice_weather_basic.pojo.WeatherResponse;

/**
 * 天气数据接口
 * @author tangxiao
 *
 */
public interface WeatherDataService {
	/**
	 * 根据城市的id获取天气数据
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);
	/**
	 * 根据城市的名称获取天气数据
	 * @param cityName
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);
}
