package com.microservice_weather_basic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberDetectionUtil {
	/**
	 * 判断是否是数字
	 * @param city
	 * @return
	 */
	public static boolean judgeNumber(String city) {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		Matcher matcher = pattern.matcher(city);
		return matcher.matches();
	}
}
