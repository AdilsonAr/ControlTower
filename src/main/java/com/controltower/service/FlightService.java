package com.controltower.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.controltower.dao.FlightDao;
import com.controltower.dao.FlightIncidentDao;
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

	public boolean cancelFlight(String flightNumber, String flightIncidentDescription) {
		FlightIncidentDao flightIncidentDao = new FlightIncidentDao();
		Flight currentFlight = flightDao.readByNumber(flightNumber);

		FlightIncident flightIncident = new FlightIncident();
		flightIncident.setTitle("Flight Cancelled");
		flightIncident.setDescription(flightIncidentDescription);
		flightIncident.setFlightStateText(FlightState.CANCELLED.getState());
		flightIncident.setTimeStamp(LocalDateTime.now());
		flightIncident.setFlight(currentFlight);

		currentFlight.setCurrentStateText(FlightState.CANCELLED.getState());
		flightDao.update(currentFlight);
		flightIncidentDao.create(flightIncident);
		return true;
	}

	public boolean landFlight(String id, String flightIncidentDescription) {
		FlightIncidentDao flightIncidentDao = new FlightIncidentDao();
		Flight currentFlight = flightDao.readByNumber(id);

		FlightIncident flightIncident = new FlightIncident();
		flightIncident.setTitle("Flight has landed");
		flightIncident.setDescription(flightIncidentDescription);
		flightIncident.setFlightStateText(FlightState.LANDED.getState());
		flightIncident.setTimeStamp(LocalDateTime.now());
		flightIncident.setFlight(currentFlight);

		currentFlight.setCurrentStateText(FlightState.LANDED.getState());
		currentFlight.setDateTimeArrival(LocalDateTime.now());
		flightDao.update(currentFlight);
		flightIncidentDao.create(flightIncident);
		return true;
	}
}
