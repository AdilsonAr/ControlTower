package com.controltower;

import java.util.List;

import com.controltower.dao.FlightDao;
import com.controltower.model.Aircraft;
import com.controltower.model.flight.Flight;
import com.controltower.service.AircraftService;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		AircraftService service= new AircraftService();
		List<Aircraft> list=service.getAllowed();
		list.forEach(x->{
			System.out.println(x.getModel());
		});
	}
	
	@org.junit.jupiter.api.Test
	void test2() {
		FlightDao dao=new FlightDao();
		
		Flight flight=dao.readById(1);
		System.out.println(flight.getCurrentStateText());
		flight.setCurrentStateText("LANDED");
		dao.update(flight);
		System.out.println((dao.readById(1)).getCurrentStateText());
	}

}
