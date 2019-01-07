package com.microservice_weather_basic.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.microservice_weather_basic.pojo.City;
import com.microservice_weather_basic.service.CityDataService;
import com.microservice_weather_basic.service.WeatherDataService;

/**
 * 天气数据同步
 * @author tangxiao
 *
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	private Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	@Autowired
	private CityDataService cityService;
	@Autowired
	private WeatherDataService weatherService;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("定时器开始获取数据");
		//获取城市ID列表
		List<City> cityList = null;
		try {
			cityList = cityService.listCity();
		} catch (Exception e) {
			logger.error("Exception！",e);
			e.printStackTrace();
		}
		//遍历城市ID获取天气
		for(City city : cityList) {
			String cityId = city.getCityId();
			logger.info("城市id为："+cityId);
			weatherService.synDateByCity(cityId);
		}
		logger.info("定时器获取数据完成");
	}

}
