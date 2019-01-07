package com.microservice_weather_basic.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市集合
 * @author tangxiao
 *
 */
@XmlRootElement(name = "c")	//xml根元素
@XmlAccessorType(XmlAccessType.FIELD) //访问类型 ：XmlAccessType.FIELD:按照字段访问
public class CityList {
	@XmlElement(name = "d")
	private List<City> cityList;

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	
	
}
