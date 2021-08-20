package com.controltower.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.controltower.dao.FlightDao;
import com.controltower.model.flight.Flight;
import com.controltower.model.flight.FlightIncident;
import com.controltower.model.flight.FlightState;

public class FlightService {
	private FlightDao flightDao;

	public FlightService() {
		flightDao = new FlightDao();
	}

	public List<Flight> readAll() {
		return flightDao.readAll();
	}

	public List<Flight> readByDay(LocalDate date) {
		return flightDao.readByDay(date);
	}

	public Flight readById(int id) {
		return flightDao.readById(id);
	}

	public boolean cancelFlight(int id, String flightIncidentDescription) {
		Flight currentFlight = flightDao.readById(id);
		List<FlightIncident> list = new ArrayList<>();
		FlightIncident flightIncident = new FlightIncident();
		flightIncident.setFlight(currentFlight);
		flightIncident.setTitle("Flight Cancelled");
		flightIncident.setDescription(flightIncidentDescription);
		flightIncident.setTimeStamp(LocalDateTime.now());
		list.add(flightIncident);
		currentFlight.setListFlightIncidents(list);
		currentFlight.setCurrentState(FlightState.CANCELLED);
		return true;
	}
}
