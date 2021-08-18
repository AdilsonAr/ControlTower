package com.controltower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.controltower.service.EMailSenderService;

@SpringBootApplication
public class ControlTowerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ControlTowerApplication.class, args);
		EMailSenderService.emailDelivery("elsarco12385@gmail.com", "https://docs.google.com/spreadsheets/d/16eH4O3T7OP78ImxRVsKxd-8SVh5dwB6DRUczkNT8vcg/edit?usp=sharing");
	}

}
