package com.controltower.configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;

@Configuration
public class DriveProviderConfiguration extends GoogleServicesConfiguration{
	@Bean
	public Drive getDrive() throws GeneralSecurityException, IOException {
		// Build a new authorized API client service.
        Drive service = new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), 
        		JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
        return service;
	}
}
