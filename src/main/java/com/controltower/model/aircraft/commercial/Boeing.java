package com.controltower.model.aircraft.commercial;


public class Boeing extends AircraftCommercial {

	public Boeing(String model, double rangeFuelTank, int passengerCapacity) {
		super(model, rangeFuelTank, passengerCapacity);
	}

	public Boeing(String model, double rangeFuelTank, boolean isAvailable, int passengerCapacity) {
		super(model, rangeFuelTank, isAvailable, passengerCapacity);
	}

}
