package com.controltower.configuration;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.sheets.v4.SheetsScopes;

import lombok.Getter;

@Getter
public class GoogleCredentialConfiguration {
	private Credential credential;
	private static GoogleCredentialConfiguration googleCredentialConfiguration=null;
	private GoogleCredentialConfiguration() throws IOException {
		List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS, DriveScopes.DRIVE);
		// You can specify a credential file by providing a path to GoogleCredentials.
		// Otherwise credentials are read from the GOOGLE_APPLICATION_CREDENTIALS
		// environment variable.
		credential = GoogleCredential.getApplicationDefault().createScoped(scopes);
	}
	
	public static GoogleCredentialConfiguration getInstance() throws IOException {
		if(googleCredentialConfiguration==null) {
			googleCredentialConfiguration= new GoogleCredentialConfiguration();
		}
		return googleCredentialConfiguration;
	}
}
