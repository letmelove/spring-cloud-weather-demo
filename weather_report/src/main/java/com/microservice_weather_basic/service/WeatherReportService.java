package com.microservice_weather_basic.service;
/**
 * 天气预报服务接口
 * @author tangxiao
 *
 */

import com.microservice_weather_basic.pojo.Weather;

public interface WeatherReportService {
	/**
	 * 根据城市id或城市名称查询天气信息
	 * @param
	 * @return
	 */
	Weather getDataByCity(String city);
}
