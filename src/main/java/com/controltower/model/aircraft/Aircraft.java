package com.controltower.model.aircraft;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public abstract class Aircraft {

	@Getter
	@Setter
	private String model;

	@Getter
	@Setter
	private double rangeFuelTank;

	@Getter
	@Setter
	private boolean isAvailable;

	public Aircraft(String model, double rangeFuelTank) {
		this.model = model;
		this.rangeFuelTank = rangeFuelTank;
	}

	public Aircraft(String model, double rangeFuelTank, boolean isAvailable) {
		this(model, rangeFuelTank);
		this.isAvailable = isAvailable;
	}

}
