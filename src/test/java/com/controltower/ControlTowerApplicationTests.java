package com.controltower;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.controltower.service.SheetsProviderService;
import com.google.api.services.sheets.v4.Sheets;

@SpringBootTest
class ControlTowerApplicationTests {
	@Autowired
	SheetsProviderService sheetsProviderService;
	
	@Test
	void sheets() {
		Sheets sheets=null;
		try {
			sheets=sheetsProviderService.getSheets();
		} catch (IOException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		assertNotNull(sheets);
	}

}
