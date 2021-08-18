package com.controltower;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.api.services.sheets.v4.Sheets;

@SpringBootTest
class ControlTowerApplicationTests {
	@Autowired
	private Sheets sheets;
	
	@Test
	void sheets() {
		assertNotNull(sheets);
	}

}
