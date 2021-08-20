package com.controltower;

import com.controltower.model.flight.Flight;
import com.controltower.service.FlightService;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		/*
		AircraftService service= new AircraftService();
		List<Aircraft> list=service.getAllowed();
		list.forEach(x->{
			System.out.println(x.getModel());
		});
		*/
	}
	
	@org.junit.jupiter.api.Test
	void test2() {
		/*
		Flight flight=dao.readById(1);
		System.out.println(flight.getCurrentStateText());
		flight.setCurrentStateText("LANDED");
		dao.update(flight);
		System.out.println((dao.readById(1)).getCurrentStateText());
		*/
	}
	
	@org.junit.jupiter.api.Test
	void test3() {
		/*
		FlightDao dao=new FlightDao();
		Flight flight=dao.readByNumber("YH 56");
		System.out.println(flight.getFlightNumber());
		System.out.println(flight.getIdFlight());
		*/
	}
	
	@org.junit.jupiter.api.Test
	void test4() {
		FlightService flightService=new FlightService();
		System.out.println(flightService.readById(10).getCurrentStateText());
		flightService.cancelFlight(10, "Wheather was bad");
		System.out.println(flightService.readById(10).getCurrentStateText());
	}

}
