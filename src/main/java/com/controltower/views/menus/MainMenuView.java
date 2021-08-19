package com.controltower.views.menus;

import java.util.Scanner;

import com.controltower.views.View;
import com.controltower.views.printers.Printer;

public class MainMenuView extends View {

	public MainMenuView(Scanner scanner, Printer printer) {
		super(scanner, printer);
	}

	@Override
	public void show() {
		do {
			try {
				print.printMessage("1. Airport Menu");
				print.printMessage("2. Airline Menu");
				print.printMessage("3. Flight Menu");
				print.printMessage("4. Exit");
				print.printMessage("Select option: ");
				this.option = Integer.parseInt(scanner.next());
				print.clearScreen();
				selectOption(this.option);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				print.printException("enter a number between 1-4", e);
				this.option = 0;
				scanner.next();
			}
		} while (this.option != 4);

	}

	protected void selectOption(int option) {
		switch (option) {
		case 1:
			selectMenu(new AirportView(scanner, print));
			break;
		case 2:
			selectMenu(new AirlineView(scanner, print));
			break;
		case 3:
			selectMenu(new FlightView(scanner, print));
			break;
		case 4:
			exit();
			break;
		default:
			print.printError("Select a valid option");
			break;
		}
	}

}
