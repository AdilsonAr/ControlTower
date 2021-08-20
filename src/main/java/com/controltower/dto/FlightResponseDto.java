package com.controltower.dto;

import java.time.LocalDateTime;

import com.controltower.model.flight.Flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponseDto {
	private int idFlight;
	private String flightNumber;
	private String OriginAirport;
	private String DestinationAirport;
	private LocalDateTime dateTimeDeparture;
	private LocalDateTime dateTimeArrival;
	private LocalDateTime expectedDateTimeArrival;
	private String Aircraft;
	private String Airline;
	private String currentStateText;
	
	public static FlightResponseDto  toDto(Flight flight) {
		return new FlightResponseDto(flight.getIdFlight(), flight.getFlightNumber(),
				flight.getOriginAirport().getName(), flight.getDestinationAirport().getName(),
				flight.getDateTimeDeparture(), flight.getDateTimeArrival(),
				flight.getExpectedDateTimeArrival(), flight.getAircraft().getModel(),
				flight.getAirline().getName(), flight.getCurrentStateText());
	}
}
