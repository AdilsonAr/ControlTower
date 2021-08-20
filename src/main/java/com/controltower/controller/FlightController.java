package com.controltower.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.controltower.dto.FlightResponseDto;
import com.controltower.model.flight.FlightIncident;
import com.controltower.service.FlightService;
import com.controltower.service.SheetsWriterService;

public class FlightController {
	private FlightService flightService;
	private SheetsWriterService sheetsWriterService;

	public FlightController() throws IOException, GeneralSecurityException {
		flightService = new FlightService();
		sheetsWriterService = new SheetsWriterService();
	}

	public List<FlightResponseDto> get() {
		List<FlightResponseDto> listDtos = new ArrayList<>();
		(flightService.readAll()).forEach(x -> listDtos.add(FlightResponseDto.toDto(x)));
		return listDtos;
	}

	public boolean cancelFlight(String flightNumber, String flightIncidentDescription) {
		return flightService.cancelFlight(flightNumber.toUpperCase().trim(), flightIncidentDescription);
	}
	
	public boolean flightLanded(int flightNumber, String flightIncidentDescription) {
		return flightService.cancelFlight(flightNumber, flightIncidentDescription);
	}

	public String sendReport(int idFlight, String email) throws IOException {
		return sheetsWriterService.createReportByFlight(idFlight, email);
	}

	/*
	 * DateTimeFormatter formatterDateOnly =
	 * DateTimeFormatter.ofPattern("yyyy-MM-dd"); LocalDate date= LocalDate.of(2021,
	 * 1, 3); System.out.println(flightController.sendReportByDay(date,
	 * "cycles.250@gmail.com"));
	 */
	public String sendReportByDay(LocalDate date, String email) throws IOException {
		return sheetsWriterService.createReportByDay(date, email);
	}
}
