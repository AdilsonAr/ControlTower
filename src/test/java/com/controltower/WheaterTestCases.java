package com.controltower;

import static org.junit.Assert.*;

import org.junit.Test;

import com.controltower.service.WeatherService;

public class WheaterTestCases {
	@Test
	public void test6() {
		String weather=WeatherService.getOneCityWeather("San Salvador");
		assertNotNull(weather);
		assertTrue(!weather.isBlank());
		System.out.println(weather);
	}
}
