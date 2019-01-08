package com.microservice_weather_basic.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.microservice_weather_basic.pojo.City;
import com.microservice_weather_basic.pojo.CityList;
import com.microservice_weather_basic.service.CityDataService;
import com.microservice_weather_basic.util.XmlBuilderUtil;
@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		//读取xml文件
		Resource resouce = new ClassPathResource("citylist.xml");
		//读取输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(resouce.getInputStream(),"UTF-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		
		while((line = br.readLine())!=null) {
			buffer.append(line);
		}
		br.close();
		
		//xml数据转为java对象
		CityList cityList = (CityList)XmlBuilderUtil.xmlStrToObject(CityList.class, buffer.toString());
		return cityList.getCityList();
	}

}
