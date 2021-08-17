package com.controltower.model.airport;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.controltower.model.aircraft.Aircraft;

import java.util.ArrayList;

@Data
public class Airport {

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private Address address;

	@Getter
	@Setter
	private String currentWeather;

	@Getter
	@Setter
	private List<Aircraft> listAircraftTypesAllowed;

	public Airport(String name, Address address) {
		this.name = name;
		this.address = address;
		this.listAircraftTypesAllowed = new ArrayList<>();
	}

	public Airport(String name, Address address, List<Aircraft> listAircraftTypesAllowed) {
		this.name = name;
		this.address = address;
		this.listAircraftTypesAllowed = listAircraftTypesAllowed;
	}

}
