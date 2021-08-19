package com.controltower.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.controltower.dto.FlightResponseDto;
import com.controltower.service.FlightService;
import com.controltower.service.SheetsWriterService;

public class FlightController {
	private FlightService flightService;
	private SheetsWriterService sheetsWriterService;
	
	public FlightController() {
		
	}
	
	public List<FlightResponseDto> get(){
		List<FlightResponseDto> listDtos=new ArrayList<>();
		(flightService.readAll()).forEach(x->listDtos.add(FlightResponseDto.toDto(x)));
		return listDtos;
	}

	public boolean get(int idFlight, String email) throws IOException{
		sheetsWriterService.createReportByFlight(idFlight, email);
		return true;
	}
}
