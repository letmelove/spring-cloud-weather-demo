package com.microservice_weather_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.microservice_weather_basic.service.CityDataService;
import com.microservice_weather_basic.service.WeatherDataService;
import com.microservice_weather_basic.service.WeatherReportService;

@Controller
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	private CityDataService cityDataService;
	@Autowired
	private WeatherReportService reportService;

	@GetMapping("/citydata/{city}")
	public String getReportByCity(@PathVariable("city") String city, Model model) throws Exception {
		model.addAttribute("title", "天气预报查询系统");
		model.addAttribute("citys", city);
		model.addAttribute("cityList",cityDataService.listCity());
		model.addAttribute("report",reportService.getDataByCity(city));
		return "weather//report";
	}
}
