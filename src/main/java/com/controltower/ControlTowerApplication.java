package com.controltower;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.controltower.controller.FlightController;

public class ControlTowerApplication {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		FlightController flightController;
		try {
			flightController = new FlightController();
			System.out.println("numero de vuelos: "+flightController.get().size());
			System.out.println(flightController.sendReport(5, "cycles.250@gmail.com"));
		} catch (IOException | GeneralSecurityException e1) {
			System.out.println("error ocurred " + e1.getCause());
		} 
		
	}
	
}
