package com.controltower;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.api.services.drive.Drive;
import com.google.api.services.sheets.v4.Sheets;

@SpringBootTest
class ControlTowerApplicationTests {
	@Autowired
	private Sheets sheets;
	@Autowired
	private Drive drive;
	
	@Test
	void sheets() {
		assertNotNull(sheets);
	}
	
	@Test
	void drive() throws IOException {
		assertNotNull(drive);
	}

}