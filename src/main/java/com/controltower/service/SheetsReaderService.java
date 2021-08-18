package com.controltower.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controltower.configuration.SheetsProviderConfiguration;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.ValueRange;

@Service
public class SheetsReaderService {

	@Autowired
	private static Sheets sheets;

	public static String getIdFromUrl(String url) {
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

	public static List<ValueRange> readReportFromUrl(String url) {
		List<String> ranges = Arrays.asList("A2", "C1000");
		String spreadSheetId = getIdFromUrl(url);
		try {
			sheets = new SheetsProviderConfiguration().getSheets();
			BatchGetValuesResponse readResult = sheets.spreadsheets().values().batchGet(spreadSheetId).setRanges(ranges)
					.execute();

			return readResult.getValueRanges();
		} catch (IOException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

}
