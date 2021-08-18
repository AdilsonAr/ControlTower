package com.controltower.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controltower.service.SheetsReaderService;
import com.google.api.services.sheets.v4.model.ValueRange;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
	@GetMapping
	public ResponseEntity<?> get() {
		List<ValueRange> values = SheetsReaderService.readReportFromUrl(
				"https://docs.google.com/spreadsheets/d/1NZcrtDLM_UAFJmH84kp4W2uC8-To2yJoauCvtghotAE/edit#gid=0");
		return new ResponseEntity<>(values.get(0), HttpStatus.OK);
	}
}
