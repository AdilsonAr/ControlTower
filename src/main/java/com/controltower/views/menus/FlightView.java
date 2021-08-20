package com.controltower.views.menus;

import java.util.List;
import java.util.Scanner;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import java.lang.Exception;
import java.time.format.DateTimeFormatter;

import com.controltower.controller.FlightController;
import com.controltower.dto.FlightResponseDto;
import com.controltower.views.View;
import com.controltower.views.printers.Printer;
import com.controltower.views.printers.PrinterConsole;
import com.google.common.collect.Table;

public class FlightView extends View {

	private FlightController flightController;

	public FlightView(Scanner scanner, Printer printer) {
		super(scanner, printer);
		try {
			flightController = new FlightController();
		} catch (Exception ex) {
			printer.printException("error getting flight menu", ex);
		}
	}

	@Override
	public void show() {
		do {
			try {
				print.printMessage("1. List all flights");
				print.printMessage("2. Send flights list by email");
				print.printMessage("3. Mark flight as landed");
				print.printMessage("4. Mark flight as cancelled");
				print.printMessage("5. Create flight");
				print.printMessage("6. Create list of flights from spreadsheet");
				print.printMessage("7. exit");
				option = Integer.parseInt(scanner.next());
				selectOption(option);
			} catch (Exception e) {
				print.printException("enter a valid number", e);
			}
		} while (option != 7);
	}

	@Override
	protected void selectOption(int option) {
		switch (option) {
		case 1:
			getListOfFlights();
			break;

		case 2:
			break;

		case 3:
			break;

		case 4:
			break;

		case 5:
			break;

		case 6:
			break;

		case 7:
			exit();
			break;

		default:
			print.printError("Select a valid option");
		}
	}

	private void getListOfFlights() {
		PrinterConsole p = (PrinterConsole) print;
		p.table.setHeaders("Flight number", "Airline", "Aircraft", "Origin Airport", "Destination Airport",
				"Departure Time", "Arrival Time");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		for (FlightResponseDto item : flightController.get()) {
			p.table.addRow(item.getFlightNumber(), item.getAirline(), item.getAircraft(), item.getOriginAirport(),
					item.getDestinationAirport(), item.getDateTimeDeparture().format(formatter),
					item.getExpectedDateTimeArrival().format(formatter));
		}
		p.table.print();
	}

}
