package com.controltower.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.services.sheets.v4.Sheets;

@Service
public class SheetsWriterService {

	public boolean createReportByFlight(int idFlight) {
		
		return false;
	}
	
	public boolean createReportByDay(LocalDate date) {
		return false;
	}
	
}
