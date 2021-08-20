package com.controltower.views.menus;

import java.util.Scanner;
import java.lang.Exception;
import com.controltower.views.View;
import com.controltower.views.printers.Printer;

public class AirportView extends View {

	public AirportView(Scanner scanner, Printer printer) {
		super(scanner, printer);
	}

	@Override
	public void show() {
		do {
			try {
				print.printMessage("4. Exit");
				print.printMessage("Select option: ");
				this.option = Integer.parseInt(scanner.next());
				selectOption(this.option);
			} catch (Exception e) {
				print.printException("enter a number between 1-4", e);
				this.option = 0;
				scanner.next();
			}
		} while (this.option != 4);
	}

	@Override
	protected void selectOption(int option) {
		switch (option) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		default:
			print.printError("Select a number between");
			break;
		}
	}

}
