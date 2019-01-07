package com.microservice_weather_basic.service;
/**
 * 城市数据服务
 * @author tangxiao
 *
 */

import java.util.List;

import com.microservice_weather_basic.pojo.City;

public interface CityDataService {
	/**
	 * 获取城市列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
