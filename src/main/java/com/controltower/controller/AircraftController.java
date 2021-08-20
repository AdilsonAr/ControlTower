package com.controltower.controller;

import java.util.List;

import com.controltower.model.Aircraft;
import com.controltower.service.AircraftService;

public class AircraftController {
	private AircraftService aircraftService;
	public AircraftController() {
		aircraftService =new AircraftService();
	}
	
	public List<Aircraft> getAllowed(){
		return aircraftService.getAllowed();
	} 
}
