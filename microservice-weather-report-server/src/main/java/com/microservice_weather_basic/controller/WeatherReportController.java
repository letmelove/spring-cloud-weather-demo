package com.microservice_weather_basic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice_weather_basic.service.CityClient;
import com.microservice_weather_basic.service.DataClient;
import com.microservice_weather_basic.service.WeatherReportService;

@Controller
@RequestMapping("/report")
public class WeatherReportController {
	@Autowired
	private WeatherReportService reportService;
	
	@Autowired
	private DataClient dataClient;
	
	@Autowired
	private CityClient cityClient;

	@GetMapping("/citydata")
	public String getReportByCity(@RequestParam(required=false) String citys,Model model) throws Exception {
		if(null==citys) {
			citys = "101280101";
		}
		model.addAttribute("title", "天气预报查询系统");
		model.addAttribute("citys", citys);
		model.addAttribute("cityList", dataClient.listCity());
		model.addAttribute("report", reportService.getDataByCity(citys));
		return "weather//report";
	}
	

}
