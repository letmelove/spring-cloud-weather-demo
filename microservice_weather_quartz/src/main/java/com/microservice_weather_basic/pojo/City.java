package com.microservice_weather_basic.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 从xml里获取城市数据
 * @author tangxiao
 *
 */
@XmlRootElement(name = "d")	//xml根元素
@XmlAccessorType(XmlAccessType.FIELD) //访问类型 ：XmlAccessType.FIELD:按照字段访问
public class City {
	@XmlAttribute(name = "d1")
	private String cityId;
	@XmlAttribute(name = "d2")
	private String cityName;
	@XmlAttribute(name = "d3")
	private String cityCode;
	@XmlAttribute(name = "d4")
	private String proince;
	
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getProince() {
		return proince;
	}
	public void setProince(String proince) {
		this.proince = proince;
	}
	
	
}
