package com.microservice_weather_basic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.microservice_weather_basic.pojo.City;
import com.microservice_weather_basic.service.WeatherReportService;

@Controller
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	private WeatherReportService reportService;

	@GetMapping("/citydata/{citys}")
	public String getReportByCity(@PathVariable("citys") String citys, Model model) throws Exception {
		// 获取城市ID列表
		List<City> cityList = null;
		try {
			cityList = new ArrayList<>();
			City city = new City();
			city.setCityId("101280601");
			city.setCityName("深圳");
			cityList.add(city);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("title", "天气预报查询系统");
		model.addAttribute("citys", citys);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", reportService.getDataByCity(citys));
		return "weather//report";
	}
}
