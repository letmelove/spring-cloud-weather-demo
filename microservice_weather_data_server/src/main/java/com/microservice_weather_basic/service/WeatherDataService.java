package com.microservice_weather_basic.service;

import com.microservice_weather_basic.pojo.WeatherResponse;

/**
 * 天气数据接口
 * 
 * @author tangxiao
 *
 */
public interface WeatherDataService {
	/**
	 * 根据城市id或城市名称拼接地址
	 * @param city 城市id或城市名称
	 * @return
	 */
	WeatherResponse getData(String city);

	/**
	 * 获取天气数据
	 * 
	 * @param url 地址
	 * @return
	 */
	WeatherResponse doGetWeahter(String url);
	
}
