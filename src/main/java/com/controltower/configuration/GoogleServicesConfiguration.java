package com.controltower.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.api.client.auth.oauth2.Credential;

public abstract class GoogleServicesConfiguration {
	protected static final String APPLICATION_NAME = "ControlTower";
	@Autowired
	protected Credential credential;
}
