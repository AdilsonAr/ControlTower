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
	private int idOriginAirport;
	private int idDestinationAirport;
	private LocalDateTime dateTimeDeparture;
	private LocalDateTime dateTimeArrival;
	private LocalDateTime expectedDateTimeArrival;
	private int idAircraft;
	private int idAirline;
	private String currentStateText;
	
	public static FlightResponseDto  toDto(Flight flight) {
		return new FlightResponseDto(flight.getIdFlight(), flight.getFlightNumber(),
				flight.getOriginAirport().getIdAirport(), flight.getDestinationAirport().getIdAirport(),
				flight.getDateTimeDeparture(), flight.getDateTimeArrival(),
				flight.getExpectedDateTimeArrival(), flight.getAircraft().getIdAircraft(),
				flight.getAirline().getIdAirline(), flight.getCurrentStateText());
	}
}
