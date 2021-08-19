package com.controltower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.controltower.service.EMailSenderService;
import com.controltower.service.WeatherService;

@SpringBootApplication
public class ControlTowerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ControlTowerApplication.class, args);
		System.out.println(WeatherService.getOneCityWeather("madrid"));
	}

}
