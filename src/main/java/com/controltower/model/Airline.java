package com.controltower.model;

import java.util.List;

import com.controltower.model.flight.Flight;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Airline {

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private List<Flight> listFlights;

	public Airline(String name) {
		this.name = name;
	}

	public Airline(String name, List<Flight> listFlights) {
		this.name = name;
		this.listFlights = listFlights;
	}

}
