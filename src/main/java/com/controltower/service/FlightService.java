package com.controltower.service;

import java.util.List;

import com.controltower.dao.FlightDao;
import com.controltower.model.flight.Flight;

public class FlightService {
	private FlightDao flightDao;
	public FlightService() {
		flightDao=new FlightDao();
	}
	
	public List<Flight> readAll(){
		return flightDao.readAll();
	}
	
	public Flight readById(int id) {
		return flightDao.readById(id);
	}
}
