package com.controltower.model.flight;

import lombok.Getter;

@Getter
public enum FlightState {
	STAND_BY("STAND_BY"), ON_FLIGHT("ON_FLIGHT"), LANDED("LANDED"), CANCELLED("CANCELLED");

	private String state;

	private FlightState(String state) {
		this.state = state;
	}

}
