package com.controltower.views.printers;

public interface Printer {

	void printMessage(String message);

	void printError(String messageError);

	void printException(String errorMessage, Exception ex);
	
	void clearScreen();

}
