package com.controltower.model.flight;

public enum FlightState {

	STAND_BY("STAND_BY"), ON_FLIGHT("ON_FLIGHT"), LANDED("LANDED"), CANCELLED("CANCELLED");

	private String s;

	FlightState(String s) {
		this.s = s;
	}

}
