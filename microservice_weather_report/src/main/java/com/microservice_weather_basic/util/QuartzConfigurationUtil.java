package com.microservice_weather_basic.util;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservice_weather_basic.job.WeatherDataSyncJob;

/**
 * 配置Quartz
 * 
 * @author tangxiao
 *
 */
@Configuration
public class QuartzConfigurationUtil {
	private static final int TIME = 1800;
	// JObDetail
	@Bean
	public JobDetail weatherDataSyncJobDetail() {
		return JobBuilder.newJob(WeatherDataSyncJob.class)
				// 起一个名字
				.withIdentity("weatherDataJobDetail")
				// 构造一个JObDetail
				.storeDurably().build();
	}

	// Trigger
	@Bean
	public Trigger weatherDataSyncTrigger() {
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
					//每隔多少秒执行一次
					.withIntervalInSeconds(TIME)
					.repeatForever();
		return TriggerBuilder.newTrigger()
					.forJob(weatherDataSyncJobDetail())
					.withIdentity("weatherDataSyncTrigger")
					.withSchedule(schedBuilder).build();
	}
}
