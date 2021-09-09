package com.controltower.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.controltower.dto.FlightResponseDto;
import com.controltower.service.FlightService;
import com.controltower.service.SheetsReaderService;
import com.controltower.service.SheetsWriterService;

public class FlightController {
	private FlightService flightService;
	private SheetsWriterService sheetsWriterService;
	private SheetsReaderService sheetsReaderService;

	public FlightController() throws IOException, GeneralSecurityException {
		flightService = new FlightService();
		sheetsWriterService = new SheetsWriterService();
		sheetsReaderService = new SheetsReaderService();
	}

	public List<FlightResponseDto> get() {
		List<FlightResponseDto> listDtos = new ArrayList<>();
		(flightService.readAll()).forEach(x -> listDtos.add(FlightResponseDto.toDto(x)));
		return listDtos;
	}

	public boolean cancelFlight(String flightNumber, String flightIncidentDescription) {
		return flightService.cancelFlight(flightNumber.toUpperCase().trim(), flightIncidentDescription);
	}

	public boolean landFlight(String flightNumber, String flightIncidentDescription) {
		return flightService.landFlight(flightNumber, flightIncidentDescription);
	}

	public String sendReport(String idFlight, String email) throws IOException {
		return sheetsWriterService.createReportByFlight(idFlight, email);
	}

	public String sendReportByDay(LocalDate date, String email) throws IOException {
		return sheetsWriterService.createReportByDay(date, email);
	}

	public String createFlightsFromSpreadsheet(String url) {
		return sheetsReaderService.readReportFromUrl(url);
	}
}
