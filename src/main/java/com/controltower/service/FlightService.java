package com.controltower.service;

import java.time.LocalDate;
import java.util.List;

import com.controltower.dao.FlightDao;
import com.controltower.model.flight.Flight;
import com.controltower.model.flight.FlightIncident;
import com.controltower.model.flight.FlightState;

public class FlightService {
	private FlightDao flightDao;
	public FlightService() {
		flightDao=new FlightDao();
	}
	
	public List<Flight> readAll(){
		return flightDao.readAll();
	}
	
	public List<Flight> readByDay(LocalDate date){
		return flightDao.readByDay(date);
	}
	
	public Flight readById(int id) {
		return flightDao.readById(id);
	}
	
	public boolean cancelFlight(int id, FlightIncident flightIncident) {
//		flightDao
//		flightDao.readById(id).setCurrentState(FlightState.CANCELLED);
		return true;
	}
}
