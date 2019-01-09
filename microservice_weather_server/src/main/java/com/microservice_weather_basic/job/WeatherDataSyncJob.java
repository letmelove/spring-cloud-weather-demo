package com.microservice_weather_basic.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.microservice_weather_basic.pojo.City;
import com.microservice_weather_basic.service.CityClient;
import com.microservice_weather_basic.service.WeatherDataCollectionService;

/**
 * 天气数据同步
 * @author tangxiao
 *
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	private Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	@Autowired
	private WeatherDataCollectionService weatherService;
	@Autowired
	private CityClient cityClient;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("定时器开始获取数据");
		//获取城市ID列表
		List<City> cityList = null;
		try {
			cityList = cityClient.listCity();
		} catch (Exception e) {
			logger.error("Exception！",e);
			e.printStackTrace();
		}
		//遍历城市ID获取天气
		for(City city : cityList) {
			String cityId = city.getCityId();
			logger.info("城市id为："+cityId);
			weatherService.sysncDataByCityId(cityId);
		}
		logger.info("定时器获取数据完成");
	}

}
