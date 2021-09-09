package com.controltower.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

	public void create(Flight flight) {
		flightDao.create(flight);
	}

	public List<Flight> readByDay(LocalDate date) {
		return flightDao.readByDay(date);
	}

	public Flight readById(int id) {
		return flightDao.readById(id);
	}

	public Flight readByFlightNumber(String flightNumber) {
		return flightDao.readByNumber(flightNumber);
	}

	public boolean cancelFlight(String flightNumber, String flightIncidentDescription) {
		Flight currentFlight = flightDao.readByNumber(flightNumber);
		return updateFlightIncident(currentFlight, "Flight cancelled", flightIncidentDescription,
				FlightState.CANCELLED.getState());
	}

	public boolean landFlight(String id, String flightIncidentDescription) {
		Flight currentFlight = flightDao.readByNumber(id);
		return updateFlightIncident(currentFlight, "Flight has landed", flightIncidentDescription,
				FlightState.LANDED.getState());
	}

	private boolean updateFlightIncident(Flight currentFlight, String incidentTitle, String flightIncidentDescription,
			String flightState) {
		boolean hasBeenUpdated = true;
		try {
			FlightIncidentDao flightIncidentDao = new FlightIncidentDao();
			FlightIncident flightIncident = new FlightIncident();
			flightIncident.setTitle(incidentTitle);
			flightIncident.setDescription(flightIncidentDescription);
			flightIncident.setFlightStateText(flightState);
			flightIncident.setTimeStamp(LocalDateTime.now());
			flightIncident.setFlight(currentFlight);
			currentFlight.setCurrentStateText(flightState);
			flightDao.update(currentFlight);
			flightIncidentDao.create(flightIncident);
		} catch (Exception ex) {
			// we log the exception
			hasBeenUpdated = false;
		}
		return hasBeenUpdated;
	}
}
