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
				print.clearScreen();
				print.printMessage("1. Airport Menu");
				print.printMessage("2. Flight Menu");
				print.printMessage("3. Exit");
				print.printMessage("Select option: ");
				this.option = Integer.parseInt(scanner.next());
				selectOption(this.option);
			} catch (java.lang.Exception e) {
				print.printException("only enter a number between 1-3", e);
				this.option = 0;
			}
		} while (this.option != 3);

	}

	protected void selectOption(int option) {
		switch (option) {
		case 1:
			selectMenu(new AirportView(scanner, print));
			break;
		case 2:
			selectMenu(new FlightView(scanner, print));
			break;
		case 3:
			exit();
			break;
		default:
			print.printError("Select a valid option");
			break;
		}
	}

}
