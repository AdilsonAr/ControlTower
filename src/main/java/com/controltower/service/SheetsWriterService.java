package com.controltower.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.controltower.configuration.GoogleServicesProvider;
import com.controltower.dto.FlightResponseDto;
import com.controltower.model.flight.Flight;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.Permission;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.ValueRange;

public class SheetsWriterService {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private DateTimeFormatter formatterDateOnly = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private Sheets sheets;
	private Drive drive;
	private FlightService flightService;
	
	public SheetsWriterService() throws IOException, GeneralSecurityException {
		sheets=GoogleServicesProvider.getSheets();
		drive=GoogleServicesProvider.getDrive();
		flightService=new FlightService();
	}
	
	public String createReportByFlight(int idFlight, String email) throws IOException {
		Flight flight=flightService.readById(idFlight);
		if(flight==null) {
			return "That flight does not exist";
		}
		FlightResponseDto dto = FlightResponseDto.toDto(flight);
		String title="Report of flight "+ idFlight;
		
		List<FlightResponseDto> listDtos=new ArrayList<>();
		listDtos.add(dto);
		return createReport(listDtos,title, email);
	}
	
	public String createReportByDay(LocalDate date, String email) throws IOException {
		String title = "Report of day " + (date).format(formatterDateOnly);
		List<FlightResponseDto> listDtos=new ArrayList<>();
		return null;//createReport(listDtos, title, email);
	}
	
	private String createReport(List<FlightResponseDto> listDtos, String title, String email) throws IOException {
		Spreadsheet spreadsheet=create(title);
		List<List<Object>> values=new ArrayList<>();
		values.add(Arrays.asList(title));
		values.add(Arrays.asList(""));
		for(FlightResponseDto c: listDtos) {
			String dateTimeDeparture="null";
			String dateTimeArrival="null";
			if((c.getDateTimeDeparture())!=null) {
				dateTimeDeparture=(c.getDateTimeDeparture()).format(formatter);
			}
			if((c.getDateTimeArrival())!=null) {
				dateTimeArrival=(c.getDateTimeArrival()).format(formatter);
			}
			values.add(Arrays.asList("Id Flight", "Flight Number", "Origin Airport", "Destination Airport",
					"Date Time Departure", "Date Time Arrival",
					"Expected Date Time Arrival", "Aircraft", "Airline", "Current State Text"));
			values.add(
					Arrays.asList(c.getIdFlight(), c.getFlightNumber(), c.getOriginAirport(), c.getDestinationAirport(),
					dateTimeDeparture, dateTimeArrival,
					(c.getExpectedDateTimeArrival()).format(formatter), c.getAircraft(), c.getAirline(), c.getCurrentStateText())
					);
		}
		
		ValueRange body = new ValueRange().setValues(values);
		
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
