package com.controltower.configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.controltower.service.GoogleCredentialService;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

@Configuration
public class SheetsProviderConfiguration {
	private static final String APPLICATION_NAME = "ControlTower";
	@Autowired
	private GoogleCredentialService googleCredentialService = new GoogleCredentialService();

	@Bean
	public Sheets getSheets() throws IOException, GeneralSecurityException {
		Credential credential = googleCredentialService.getCredentials();
		return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
				credential).setApplicationName(APPLICATION_NAME).build();
	}

}
