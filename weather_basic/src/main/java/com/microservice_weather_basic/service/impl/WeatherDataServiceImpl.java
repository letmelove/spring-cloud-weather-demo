package com.microservice_weather_basic.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice_weather_basic.pojo.WeatherResponse;
import com.microservice_weather_basic.service.WeatherDataService;
import com.microservice_weather_basic.util.NumberDetectionUtil;
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	private String url;
	private WeatherResponse wr;
	@Autowired
	private RestTemplate resttemplate;
	
	@Override
	public WeatherResponse getData(String city) {
		if(NumberDetectionUtil.judgeNumber(city)) {
			url = WEATHER_URI + "citykey=" + city;
			return doGetWeahter(url);
		}
		url = WEATHER_URI + "city=" + city;
		return doGetWeahter(url);
	}
	

	@Override
	public WeatherResponse doGetWeahter(String url) {
		// 发送一个HTTP GET请求，返回的ResponseEntity包含了响应体所映射成的对象.这里返回一个json字符串
		ResponseEntity<String> respString = resttemplate.getForEntity(url, String.class);

		// json处理框架
		ObjectMapper om = new ObjectMapper();

		// 存储json字符串
		String strBody = null;

		// 通过状态码来判断ResponseEntity是否访问成功
		if (respString.getStatusCodeValue() == 200) {
			strBody = respString.getBody();
		}

		// 把json字符串转为对象
		try {
			wr = om.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wr;
	}

}
