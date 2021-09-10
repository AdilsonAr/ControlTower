package com.controltower.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.controltower.dto.FlightResponseDto;
import com.controltower.model.Aircraft;
import com.controltower.model.Airline;
import com.controltower.model.airport.Airport;
import com.controltower.model.flight.Flight;

public class FlightMapper {
	private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static List<Flight> toModel(List<List<Object>> values){
		List<Flight> listFlights=new ArrayList<>();
		
		for (List<Object> row : values) {
            // getting a flight
        	Flight current=new Flight();
            current.setCurrentStateText(row.get(0).toString());
            try {
            	current.setDateTimeArrival(LocalDateTime.parse(row.get(1).toString(), FORMATTER));
            }catch(Exception e) {
            	//null is allowed
            }finally {
            	current.setDateTimeArrival(null);
            }
            
            current.setDateTimeDeparture(LocalDateTime.parse(row.get(2).toString(), FORMATTER));
            current.setExpectedDateTimeArrival(LocalDateTime.parse(row.get(3).toString(), FORMATTER));
            current.setFlightNumber(row.get(4).toString());
            
            Aircraft aircraft=new Aircraft();
            aircraft.setIdAircraft(Integer.parseInt(row.get(5).toString()));
            current.setAircraft(aircraft);
            
            Airline airline=new Airline();
            airline.setIdAirline(Integer.parseInt(row.get(6).toString()));
            current.setAirline(airline);
            
            Airport destination =new Airport();
            destination.setIdAirport(Integer.parseInt(row.get(7).toString()));
            current.setDestinationAirport(destination);
            Airport origin =new Airport();
            origin.setIdAirport(Integer.parseInt(row.get(7).toString()));
            current.setOriginAirport(origin);
            
            listFlights.add(current);
        }
		
		return listFlights;
	}
	
	public static List<List<Object>> toSheets(List<FlightResponseDto> flights, List<List<Object>> values){
		for(FlightResponseDto c: flights) {
			String dateTimeDeparture="null";
			String dateTimeArrival="null";
			if((c.getDateTimeDeparture())!=null) {
				dateTimeDeparture=(c.getDateTimeDeparture()).format(FORMATTER);
			}
			if((c.getDateTimeArrival())!=null) {
				dateTimeArrival=(c.getDateTimeArrival()).format(FORMATTER);
			}
			values.add(Arrays.asList("Id Flight", "Flight Number", "Origin Airport", "Destination Airport",
					"Date Time Departure", "Date Time Arrival",
					"Expected Date Time Arrival", "Aircraft", "Airline", "Current State Text"));
			values.add(
					Arrays.asList(c.getIdFlight(), c.getFlightNumber(), c.getOriginAirport(), c.getDestinationAirport(),
					dateTimeDeparture, dateTimeArrival,
					(c.getExpectedDateTimeArrival()).format(FORMATTER), c.getAircraft(), c.getAirline(), c.getCurrentStateText())
					);
		}
		return values;
	}
}
