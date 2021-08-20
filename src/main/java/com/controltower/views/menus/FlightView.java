package com.controltower.views.menus;

import java.util.Scanner;

import java.lang.Exception;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.controltower.controller.FlightController;
import com.controltower.dto.FlightResponseDto;
import com.controltower.views.View;
import com.controltower.views.printers.Printer;
import com.controltower.views.printers.PrinterConsole;

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
				print.clearScreen();
				print.printMessage("1. List all flights");
				print.printMessage("2. email flights list by flight date");
				print.printMessage("3. email flights list by flight id");
				print.printMessage("4. Mark flight as landed");
				print.printMessage("5. Mark flight as cancelled");
				print.printMessage("6. Create list of flights from spreadsheet");
				print.printMessage("7. exit");
				print.printMessage("Select option: ");
				option = Integer.parseInt(scanner.next());
				selectOption(option);
			} catch (Exception e) {
				print.printException("enter a valid number", e);
				((PrinterConsole) print).pressEnterToContinue();
			}
		} while (option != 7);
	}

	@Override
	protected void selectOption(int option) {
		switch (option) {

		// get list of flights
		case 1:
			getListOfFlights();
			break;

		// send email with flight list filtering by flight date
		case 2:
			emailFlightListByDate();
			break;

		// send email with flight list filtering by flight date
		case 3:
			emailFlightListById();
			break;

		// mark flight as landed
		case 4:
			markFlightAsLanded();
			break;

		// mark flight as cancelled
		case 5:
			markFlightAsCancelled();
			break;

		// read spreadsheet and insert flights batch
		case 6:
			createFlightsFromSpreadsheet();
			break;

		case 7:
			exit();
			break;
		default:
			print.printError("Select a valid option");
		}
	}

	private void getListOfFlights() {
		print.clearScreen();
		PrinterConsole p = (PrinterConsole) print;
		p.table.setHeaders("Flight number", "Airline", "Aircraft", "Origin Airport", "Destination Airport",
				"Departure Time", "Arrival Time", "STATUS");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		for (FlightResponseDto item : flightController.get()) {
			p.table.addRow(item.getFlightNumber(), item.getAirline(), item.getAircraft(), item.getOriginAirport(),
					item.getDestinationAirport(), item.getDateTimeDeparture().format(formatter),
					item.getExpectedDateTimeArrival().format(formatter), item.getCurrentStateText());
		}
		p.table.print();
		p.pressEnterToContinue();
	}

	private void emailFlightListByDate() {
		print.clearScreen();
		print.printMessage("Date format: yyyy-MM-dd");
		print.printMessage("Enter date: ");
		try {
			scanner.nextLine();
			String dateString = scanner.nextLine();
			print.printMessage("enter your email: ");
			String email = scanner.nextLine();
			print.printMessage(flightController.sendReportByDay(LocalDate.parse(dateString), email));
		} catch (Exception ex) {
			print.printException("Error, enter a valid date, and a valid email and try again", ex);
		} finally {
			((PrinterConsole) print).pressEnterToContinue();
		}

	}

	private void emailFlightListById() {
		print.clearScreen();
		print.printMessage("Enter flight number: ");
		try {
			scanner.nextLine();
			String flightNumber = scanner.nextLine();
			print.printMessage("enter your email: ");
			String email = scanner.nextLine();
			print.printMessage(flightController.sendReport(flightNumber, email));
		} catch (Exception ex) {
			print.printException("Error, enter a valid date, and a valid email and try again", ex);
		} finally {
			((PrinterConsole) print).pressEnterToContinue();
		}
	}

	private void markFlightAsCancelled() {
		print.clearScreen();
		print.printMessage("Enter flight number");
		try {
			scanner.nextLine();
			String idFlight = scanner.nextLine();
			print.printMessage("Enter reason for the cancellation");
			String reasonCancellation = scanner.nextLine();
			boolean isCancelled = flightController.cancelFlight(idFlight, reasonCancellation);
			print.printMessage("The flight "
					+ (isCancelled ? "was cancelled successfully" : "couldn't be cancelled, please try again"));
		} catch (Exception e) {
			print.printException("only enter integer numbers", e);
		} finally {
			((PrinterConsole) print).pressEnterToContinue();
		}
	}

	private void markFlightAsLanded() {
		print.clearScreen();
		print.printMessage("Enter flight number");
		try {
			scanner.nextLine();
			String idFlight = scanner.nextLine();
			boolean isLanded = flightController.landFlight(idFlight, "Flight landed succesfully!");
			print.printMessage(
					"The flight " + (isLanded ? "was landed successfully" : "couldn't be landed, please try again"));
		} catch (Exception e) {
			print.printException("only enter integer numbers", e);
		} finally {
			((PrinterConsole) print).pressEnterToContinue();
		}
	}

	private void createFlightsFromSpreadsheet() {
		print.clearScreen();
		print.printMessage("Enter the google spreadsheet url");
		try {
			scanner.nextLine();
			String url = scanner.nextLine();
			print.printMessage(flightController.createFlightsFromSpreadsheet(url));
		} catch (Exception e) {
			print.printException("Please verify the spreadsheet url and try again", e);
		} finally {
			((PrinterConsole) print).pressEnterToContinue();
		}
	}

}
