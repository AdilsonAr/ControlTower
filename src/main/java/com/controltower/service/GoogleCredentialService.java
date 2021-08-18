package com.controltower.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.SheetsScopes;

@Service
public class GoogleCredentialService {

	public Credential getCredentials() throws IOException {
		List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
		// You can specify a credential file by providing a path to GoogleCredentials.
		// Otherwise credentials are read from the GOOGLE_APPLICATION_CREDENTIALS
		// environment variable.
		GoogleCredential credentials = GoogleCredential.getApplicationDefault().createScoped(scopes);
		return credentials;
	}

}
