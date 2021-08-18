package com.controltower.model.flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.controltower.model.Airline;
import com.controltower.model.aircraft.Aircraft;
import com.controltower.model.airport.Airport;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Flight {

	@Getter
	private String flightNumber;

	@Getter
	private Airport originAirport;

	@Getter
	private Airport destinationAirport;

	@Getter
	@Setter
	private LocalDateTime dateTimeDeparture;

	@Getter
	@Setter
	private LocalDateTime dateTimeArrival;

	@Getter
	@Setter
	private LocalDateTime expectedDateTimeArrival;

	@Getter
	@Setter
	private Aircraft aircraft;

	@Getter
	@Setter
	private Airline airline;

	@Getter
	@Setter
	private List<FlightIncident> listFlightIncidents;

	@Getter
	@Setter
	private FlightState currentState;

	public Flight(Airport originAirport, Airport destinationAirport, LocalDateTime dateTimeDeparture,
			LocalDateTime dateTimeArrival, Aircraft aircraft, Airline airline) {
		this.flightNumber = UUID.randomUUID().toString();
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.dateTimeArrival = dateTimeArrival;
		this.dateTimeDeparture = dateTimeDeparture;
		this.aircraft = aircraft;
		this.airline = airline;
	}

}
