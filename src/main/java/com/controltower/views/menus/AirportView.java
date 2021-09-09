package com.controltower.views.menus;

import java.util.Scanner;

import com.controltower.controller.AircraftController;
import com.controltower.model.Aircraft;
import com.controltower.views.View;
import com.controltower.views.printers.Printer;
import com.controltower.views.printers.PrinterConsole;

public class AirportView extends View {

	private AircraftController aircraftController;

	public AirportView(Scanner scanner, Printer printer) {
		super(scanner, printer);
		this.aircraftController = new AircraftController();
	}

	@Override
	public void show() {
		do {
			try {
				print.clearScreen();
				print.printMessage("1. Get list of allowed aircrafts");
				print.printMessage("2. Exit");
				print.printMessage("Select option: ");
				this.option = Integer.parseInt(scanner.next());
				selectOption(this.option);
			} catch (Exception e) {
				print.printException("enter a number between 1-2", e);
				((PrinterConsole) print).pressEnterToContinue();
			}
		} while (this.option != 2);
	}

	@Override
	protected void selectOption(int option) {
		switch (option) {
		case 1:
			getListOfAllowedAircrafts();
			break;
		case 2:
			exit();
			break;
		default:
			print.printError("Select a number between");
			break;
		}
	}

	private void getListOfAllowedAircrafts() {
		print.clearScreen();
		print.printMessage("List of Aircrafts allowed: ");
		PrinterConsole p = (PrinterConsole) print;
		p.table.setHeaders("Model", "Passenger Capacity", "Fuel Tank Range");
		for (Aircraft item : aircraftController.getAllowed()) {
			p.table.addRow(item.getModel(), String.valueOf(item.getPassengerCapacity()),
					String.valueOf(item.getRangeFuelTank()));
		}
		p.table.print();
		p.pressEnterToContinue();
	}

}
