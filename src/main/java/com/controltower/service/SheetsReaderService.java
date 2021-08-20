package com.controltower.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.controltower.configuration.GoogleServicesProvider;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.controltower.model.flight.Flight;

public class SheetsReaderService {

	private static Sheets sheets;

	private static String getIdFromUrl(String url) {
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
	}

}
