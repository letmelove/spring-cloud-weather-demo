package com.microservice_weather_basic.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice_weather_basic.service.WeatherDataCollectionService;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
	// redis超时时间
	private static final long TIME_OUT = 1800L;
	
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	@Autowired
	private RestTemplate resttemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public void sysncDataByCityId(String cityId) {
		this.saveWeatherData(WEATHER_URI + "citykey=" + cityId);
	}

	/**
	 * 将天气数据存储到缓存中
	 * 
	 * @param url
	 */
	private void saveWeatherData(String url) {
		String key = url;
		// 存储json字符串
		String strBody = null;

		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

		// 发送一个HTTP GET请求，返回的ResponseEntity包含了响应体所映射成的对象.这里返回一个json字符串
		ResponseEntity<String> respString = resttemplate.getForEntity(url, String.class);

		// 通过状态码来判断ResponseEntity是否访问成功
		if (respString.getStatusCodeValue() == 200) {
			strBody = respString.getBody();
		}
		// 数据写入缓存中
		ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);

	}

}
