package com.controltower.model.flight;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class FlightIncident {

	@Getter
	@Setter
	private FlightState flightState;

	@Getter
	@Setter
	private String title;

	@Getter
	@Setter
	private String description;

	@Getter
	private LocalDateTime timeStamp;

	public FlightIncident(FlightState flightState, String title) {
		this.flightState = flightState;
		this.title = title;
		this.timeStamp = LocalDateTime.now();
	}

	public FlightIncident(FlightState flightState, String title, String description) {
		this(flightState, title);
		this.description = description;
	}

}
