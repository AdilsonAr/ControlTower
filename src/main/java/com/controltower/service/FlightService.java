package com.controltower.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controltower.model.flight.Flight;
import com.controltower.repository.FlightRepository;

@Service
public class FlightService {
	@Autowired
	private FlightRepository flightRepository;
	public List<Flight> readAll(){
		return flightRepository.findAll();
	}
	
	public Flight readById(int id) {
		return flightRepository.findById(id).get();
	}
}
