package com.controltower.views;

import java.util.Scanner;

import com.controltower.views.printers.Printer;

public abstract class View {

	protected int option;
	protected Scanner scanner;
	protected Printer print;

	public View(Scanner scanner, Printer printer) {
		this.scanner = scanner;
		this.print = printer;
	}

	public abstract void show();

	protected abstract void selectOption(int option);

	protected void selectMenu(View v) {
		v.show();
	}

	protected void exit() {
		print.clearScreen();
	}

}
