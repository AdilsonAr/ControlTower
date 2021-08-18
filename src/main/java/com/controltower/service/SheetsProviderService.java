package com.controltower.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

@Service
public class SheetsProviderService {
	private static final String APPLICATION_NAME = "ControlTower";
	@Autowired
	private GoogleCredentialService googleCredentialService;

    public Sheets getSheets() throws IOException, GeneralSecurityException {
        Credential credential = googleCredentialService.getCredentials();
        return new Sheets.Builder(
          GoogleNetHttpTransport.newTrustedTransport(), 
          JacksonFactory.getDefaultInstance(), credential)
          .setApplicationName(APPLICATION_NAME)
          .build();
    }
}
