package com.controltower.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controltower.dto.FlightResponseDto;
import com.controltower.model.flight.Flight;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.Permission;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.ValueRange;

@Service
public class SheetsWriterService {
	@Autowired
	private Sheets sheets;
	@Autowired
	private Drive drive;
	@Autowired
	private FlightService flightService;
	public String createReportByFlight(int idFlight, String email) throws IOException {
		Flight flight=flightService.readById(idFlight);
		FlightResponseDto dto = FlightResponseDto.toDto(flight);
		String title="Report of flight "+ idFlight;
		ValueRange body = new ValueRange()
	      .setValues(Arrays.asList(
	        Arrays.asList("Expenses January"), 
	        Arrays.asList("books", "30"), 
	        Arrays.asList("pens", "10"),
	        Arrays.asList("Expenses February"), 
	        Arrays.asList("clothes", "20"),
	        Arrays.asList("shoes", "5")));
		
		return createReport(body,title, email);
	}
	
	public String createReportByDay(LocalDate date, String email) throws IOException {
		SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
		String title = "Report of day " + format.format(date);

		ValueRange body = new ValueRange().setValues(Arrays.asList(Arrays.asList("Expenses January"),
				Arrays.asList("books", "30"), Arrays.asList("pens", "10"), Arrays.asList("Expenses February"),
				Arrays.asList("clothes", "20"), Arrays.asList("shoes", "5")));

		return createReport(body, title, email);
	}
	
	private String createReport(ValueRange body, String title, String email) throws IOException {
		Spreadsheet spreadsheet=create(title);
		write(spreadsheet.getSpreadsheetId(), body);
		createPermission(spreadsheet.getSpreadsheetId(), email);
		String message="The report you requested is already available with this URL: " + spreadsheet.getSpreadsheetUrl();
		return message;
	}
	
	private void createPermission(String spreadSheetId, String email) throws IOException {
		Permission newPermission = new Permission();
	    newPermission.setType("user");
	    newPermission.setRole("owner");
	    newPermission.setEmailAddress(email);
	    drive.permissions().create(spreadSheetId, newPermission).setTransferOwnership(true).execute();
	}
	
	private Spreadsheet create(String title) throws IOException {
		Spreadsheet spreadsheet = new Spreadsheet()
		        .setProperties(new SpreadsheetProperties()
		                .setTitle(title));
		spreadsheet = sheets.spreadsheets().create(spreadsheet)
		        .execute();
		return spreadsheet;
	}
	
	private void write(String spreadSheetId, ValueRange body) throws IOException {
		sheets.spreadsheets().values()
	      .update(spreadSheetId, "A1", body)
	      .setValueInputOption("RAW")
	      .execute();
	}
	
}
