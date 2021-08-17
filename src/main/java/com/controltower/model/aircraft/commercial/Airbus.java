package com.controltower.model.aircraft.commercial;


public class Airbus extends AircraftCommercial {

	public Airbus(String model, double rangeFuelTank, int passengerCapacity) {
		super(model, rangeFuelTank, passengerCapacity);
	}

	public Airbus(String model, double rangeFuelTank, boolean isAvailable, int passengerCapacity) {
		super(model, rangeFuelTank, isAvailable, passengerCapacity);
	}

}
