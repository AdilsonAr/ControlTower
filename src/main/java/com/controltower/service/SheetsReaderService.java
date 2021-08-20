package com.controltower.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.controltower.configuration.GoogleServicesProvider;
import com.controltower.model.Aircraft;
import com.controltower.model.Airline;
import com.controltower.model.airport.Airport;
import com.controltower.model.flight.Flight;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.controltower.model.flight.Flight;

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
<<<<<<< HEAD
		} 
		
		return result;
	}

	public String readReportFromUrl(String url) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		List<Flight> listFlights=new ArrayList<>();
		String range = "A1:I5";
		String spreadSheetId = getIdFromUrl(url);
		try {
			
			ValueRange response = sheets.spreadsheets().values()
	                .get(spreadSheetId, range)
	                .execute();
	        List<List<Object>> values = response.getValues();
	        if (values == null || values.isEmpty()) {
	            System.out.println("No data found.");
	        } else {
	            for (List row : values) {
	                // getting a flight
	            	Flight current=new Flight();
	                current.setCurrentStateText(row.get(0).toString());
	                try {
	                	current.setDateTimeArrival(LocalDateTime.parse(row.get(1).toString(), formatter));
	                }catch(Exception e) {
	                	//null is allowed
	                }finally {
	                	current.setDateTimeArrival(null);
	                }
	                
	                current.setDateTimeDeparture(LocalDateTime.parse(row.get(2).toString(), formatter));
	                current.setExpectedDateTimeArrival(LocalDateTime.parse(row.get(3).toString(), formatter));
	                current.setFlightNumber(row.get(4).toString());
	                
	                Aircraft aircraft=new Aircraft();
	                aircraft.setIdAircraft(Integer.parseInt(row.get(5).toString()));
	                current.setAircraft(aircraft);
	                
	                Airline airline=new Airline();
	                airline.setIdAirline(Integer.parseInt(row.get(6).toString()));
	                current.setAirline(airline);
	                
	                Airport destination =new Airport();
	                destination.setIdAirport(Integer.parseInt(row.get(7).toString()));
	                current.setDestinationAirport(destination);
	                Airport origin =new Airport();
	                origin.setIdAirport(Integer.parseInt(row.get(7).toString()));
	                current.setOriginAirport(origin);
	                
	                listFlights.add(current);
	            }
	        }
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return "The information could not be loaded";
		}
		listFlights.forEach(x->flightService.create(x));
		return "The information has been added to database";
=======
		} finally {
			return result;
		}
	}

	private static ValueRange getValuesRange(String spreadSheetId, String sheetRange) {
		try {
			Sheets sheets = GoogleServicesProvider.getSheets();
			Sheets.Spreadsheets.Values.Get request = sheets.spreadsheets().values().get(spreadSheetId, sheetRange);
			request.setFields("values");
			ValueRange response = request.execute();
			return response;
		} catch (Exception ex) {
			return null;
		}
	}

	private static List<Flight> setListOfFlights(ValueRange values) {
		List<Flight> listFlights = new ArrayList<>();
		for (List<Object> item : values.getValues()) {
			System.out.println(item.get(0));
		}
		return listFlights;
	}

	public static void readReportFromUrl(String url) {
		String spreadSheetId = getIdFromUrl(url);
		ValueRange valueRange = getValuesRange(spreadSheetId, "A2:G1000");
>>>>>>> 8a64c0edb6b796d370294681274c57d41791ada7
	}

}
