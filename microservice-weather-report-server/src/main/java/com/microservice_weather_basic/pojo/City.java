package com.microservice_weather_basic.pojo;

/**
 * 从xml里获取城市数据
 * @author tangxiao
 *
 */

public class City {

	private String cityId;

	private String cityName;
	
	private String cityCode;

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
