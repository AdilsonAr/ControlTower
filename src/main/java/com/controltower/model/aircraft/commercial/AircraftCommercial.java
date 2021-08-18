package com.controltower.model.aircraft.commercial;

import com.controltower.model.aircraft.Aircraft;

import lombok.Getter;
import lombok.Setter;

public abstract class AircraftCommercial extends Aircraft {

	@Getter
	@Setter
	private int passengerCapacity;

	public AircraftCommercial(String model, double rangeFuelTank, int passengerCapacity) {
		super(model, rangeFuelTank);
		this.passengerCapacity = passengerCapacity;
	}

	public AircraftCommercial(String model, double rangeFuelTank, boolean isAvailable, int passengerCapacity) {
		super(model, rangeFuelTank, isAvailable);
		this.passengerCapacity = passengerCapacity;
	}

}
