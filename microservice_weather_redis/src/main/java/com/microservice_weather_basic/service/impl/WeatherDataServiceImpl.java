package com.microservice_weather_basic.service.impl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice_weather_basic.pojo.WeatherResponse;
import com.microservice_weather_basic.service.WeatherDataService;
import com.microservice_weather_basic.util.NumberDetectionUtil;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	private Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
	
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	private String url;
	private WeatherResponse wr;
	//redis超时时间
	private static final long TIME_OUT = 1800L;

	@Autowired
	private RestTemplate resttemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public WeatherResponse getData(String city) {
		if (NumberDetectionUtil.judgeNumber(city)) {
			url = WEATHER_URI + "citykey=" + city;
			return doGetWeahter(url);
		}
		url = WEATHER_URI + "city=" + city;
		return doGetWeahter(url);
	}

	@Override
	public WeatherResponse doGetWeahter(String url) {
		String key = url;

		// 存储json字符串
		String strBody = null;

		// json处理框架
		ObjectMapper om = new ObjectMapper();

		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

		// 先查缓存，缓存有的取缓存中的数据
		if (stringRedisTemplate.hasKey(key)) {
			logger.info("缓存中有数据");
			strBody = ops.get(key);
		} else {
			logger.info("缓存中没有数据，现在开始吧数据写入缓存中");
			// 缓存没有，再调用接口来获取数据
			// 发送一个HTTP GET请求，返回的ResponseEntity包含了响应体所映射成的对象.这里返回一个json字符串
			ResponseEntity<String> respString = resttemplate.getForEntity(url, String.class);

			// 通过状态码来判断ResponseEntity是否访问成功
			if (respString.getStatusCodeValue() == 200) {
				strBody = respString.getBody();
			}
			// 数据写入缓存中
			ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
		}

		// 把json字符串转为对象
		try {
			wr = om.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			//e.printStackTrace();
			logger.error("Error!",e);
		}
		return wr;
	}

}
