package com.controltower;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.junit.Test;

import com.controltower.dao.FlightDao;
import com.controltower.model.Aircraft;
import com.controltower.model.flight.Flight;
import com.controltower.service.AircraftService;
import com.controltower.service.FlightService;
import com.controltower.service.SheetsReaderService;
public class TestCases {
	@Test
	public void test() {
		AircraftService service= new AircraftService();
		List<Aircraft> list=service.getAllowed();
		list.forEach(x->{
			System.out.println(x.getModel());
		});
		assertTrue(list.size()>0);
	}
	
	@Test
	public void test2() {
		FlightDao dao=new FlightDao();
		Flight flight=dao.readById(2);
		System.out.println(flight.getCurrentStateText());
		flight.setCurrentStateText("LANDED");
		dao.update(flight);
		
		Flight newFlight=dao.readById(1);
		assertTrue(newFlight.getCurrentStateText().equals("LANDED"));
	}
	
	@Test
	public void test3() {
		FlightDao dao=new FlightDao();
		Flight flight=dao.readByNumber("YH 56");
		assertNotNull(flight);
		assertTrue(flight.getFlightNumber().equals("YH 56"));
	}
	
	@Test
	public void test4() {
		FlightService flightService=new FlightService();
		System.out.println(flightService.readByFlightNumber("JK 55").getCurrentStateText());
		flightService.cancelFlight("JK 55", "Wheather was bad");
		System.out.println(flightService.readByFlightNumber("JK 55").getCurrentStateText());
	}
	
	@Test
	public void test5() {
		FlightService flightService=new FlightService();
		System.out.println(flightService.readById(10).getCurrentStateText());
		flightService.landFlight("JK 55", "Wheather was god");
		System.out.println(flightService.readById(10).getCurrentStateText());
	}
	
	@Test
	public void test7() throws IOException, GeneralSecurityException {
		SheetsReaderService  sheetsReaderService=new SheetsReaderService();
		String message=sheetsReaderService.readReportFromUrl("https://docs.google.com/spreadsheets/d/16A-0NByteqdkniz4Tr6LRao5fjdeBrBbCUxBA6RYbwQ/edit?usp=sharing");
		System.out.println(message);
		assertNotNull(message);
		assertTrue(!message.isBlank());
	}
}
