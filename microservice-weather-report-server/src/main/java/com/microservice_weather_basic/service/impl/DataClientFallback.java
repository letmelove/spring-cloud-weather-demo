package com.microservice_weather_basic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.microservice_weather_basic.pojo.City;
import com.microservice_weather_basic.pojo.WeatherResponse;
import com.microservice_weather_basic.service.DataClient;
/**
 * 当调用的服务不可用时
 * @author tangxiao
 *
 */
@Component
public class DataClientFallback implements DataClient {
	/**
	 * 当获取城市列表失败的时候返回以下数据
	 */
	@Override
	public List<City> listCity() {
		List<City> cityList = new ArrayList<City>();;
		City city = new City();
		city.setCityId("101280601");
		city.setCityName("深圳");
		cityList.add(city);
		return cityList;
	}

	@Override
	public WeatherResponse getDataByCityId(String city) {
		return null;
	}

}
