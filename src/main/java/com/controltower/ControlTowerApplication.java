package com.controltower;

import java.util.Scanner;

import com.controltower.service.WeatherService;
import com.controltower.views.View;
import com.controltower.views.menus.MainMenuView;
import com.controltower.views.printers.Printer;
import com.controltower.views.printers.PrinterConsole;

public class ControlTowerApplication {

	public static void main(String[] args) {
		/*Scanner input = new Scanner(System.in);
		Printer output = new PrinterConsole();
		View startMenu = new MainMenuView(input, output);
		startMenu.show();*/
		System.out.println(WeatherService.getOneCityWeather("Miami"));
	}

}
