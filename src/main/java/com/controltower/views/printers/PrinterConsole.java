package com.controltower.views.printers;

import java.io.IOException;

public class PrinterConsole implements Printer {

	public ConsoleTable table;

	public PrinterConsole() {
		this.table = new ConsoleTable();
	}

	@Override
	public void printMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void printError(String errorMessage) {
		System.out.println(errorMessage);
	}

	@Override
	public void printException(String errorMessage, Exception ex) {
		System.out.println(errorMessage);
	}

	@Override
	public void clearScreen() {
		try {
			String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error clearing console");
		}
	}

	public void pressEnterToContinue() {
		System.out.println("Press ENTER to continue");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
