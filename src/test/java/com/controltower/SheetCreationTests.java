package com.controltower;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.controltower.service.SheetsWriterService;

@SpringBootTest
public class SheetCreationTests {
	@Autowired
	SheetsWriterService sheetsWriterService;
	
	@Test
	void sheets() throws IOException {
		String message=sheetsWriterService.createReportByFlight(1, "cycles.250@gmail.com");
		System.out.println(message);
		assertNotNull(message);
	}
}
