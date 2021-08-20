package com.controltower.views.printers;

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
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error clearing console");
		}
	}

}
