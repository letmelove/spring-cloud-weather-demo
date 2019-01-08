package com.microservice_weather_basic.service;
/*
 * 天气数据采集服务
 */
public interface WeatherDataCollectionService {
	/**
	 * 根据城市id同步天气
	 * @param cityId
	 */
	void sysncDataByCityId(String cityId);
}
