package com.controltower.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import com.controltower.configuration.GoogleServicesProvider;
import com.controltower.model.flight.Flight;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

public class SheetsReaderService {

	private Sheets sheets;
	private FlightService flightService;
	
	public SheetsReaderService() throws IOException, GeneralSecurityException {
		super();
		sheets=GoogleServicesProvider.getSheets();
		flightService =new FlightService();
	}

	private String getIdFromUrl(String url) {
		String result = "";
		try {
			String[] parts = url.split("spreadsheets/d/");
			if (parts[1].contains("/")) {
				String[] parts2 = parts[1].split("/");
				result = parts2[0];
			} else {
				result = parts[1];
			}
		} catch (Exception e) {
			result = "";
		} 
		
		return result;
	}

	public String readReportFromUrl(String url) {
		List<Flight> listFlights=new ArrayList<>();
		String range = "A2:I100";
		String spreadSheetId = getIdFromUrl(url);
		try {
			ValueRange response = sheets.spreadsheets().values()
	                .get(spreadSheetId, range)
	                .execute();
	        List<List<Object>> values = response.getValues();
	        if (values == null || values.isEmpty()) {
	            System.out.println("No data found.");
	        } else {
	        	listFlights=FlightMapper.toModel(values);
	        }
		} catch (IOException e) {
			return "The information could not be loaded";
		}
		catch (Exception e) {
			return "Verify the URL and try again later";
		}
		listFlights.forEach(x->flightService.create(x));
		return "The information has been added to database";
	}

}