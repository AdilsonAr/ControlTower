package com.controltower.model.aircraft.cargo;

import com.controltower.model.aircraft.Aircraft;

import lombok.Getter;
import lombok.Setter;

public abstract class AircraftCargo extends Aircraft {

	@Setter
	@Getter
	private int packageCapacity;

	public AircraftCargo(String model, double rangeFuelTank, int packageCapacity) {
		super(model, rangeFuelTank);
		this.packageCapacity = packageCapacity;
	}

	public AircraftCargo(String model, double rangeFuelTank, boolean isAvailable, int packageCapacity) {
		super(model, rangeFuelTank, isAvailable);
		this.packageCapacity = packageCapacity;
	}

}
