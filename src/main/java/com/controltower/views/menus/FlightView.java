package com.controltower.views.menus;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Scanner;

import com.controltower.controller.FlightController;
import com.controltower.dto.FlightResponseDto;
import com.controltower.views.View;
import com.controltower.views.printers.Printer;

public class FlightView extends View {

	public FlightView(Scanner scanner, Printer printer) {
		super(scanner, printer);
	}

	@Override
	public void show() {
		try {
			FlightController flightController = new FlightController();
			List<FlightResponseDto> listFlightsDtos = flightController.get();
//			print.printMessage("Lista de vuelos: " + listFlightsDtos.size());
			for (FlightResponseDto flightResponseDto : listFlightsDtos) {
				print.printMessage(flightResponseDto.getFlightNumber());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void selectOption(int option) {
	}

}
