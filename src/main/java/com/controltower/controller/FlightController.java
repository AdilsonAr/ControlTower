package com.controltower.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controltower.dto.FlightResponseDto;
import com.controltower.service.FlightService;
import com.controltower.service.SheetsWriterService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightService flightService;
	@Autowired
	private SheetsWriterService sheetsWriterService;
	
	@GetMapping
	public ResponseEntity<?> get(){
		List<FlightResponseDto> listDtos=new ArrayList<>();
		(flightService.readAll()).forEach(x->listDtos.add(FlightResponseDto.toDto(x)));
		return new ResponseEntity<>(listDtos, HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> get(@RequestParam int idFlight, @RequestParam String email) throws IOException{
		sheetsWriterService.createReportByFlight(idFlight, email);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
