package com.controltower.service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeatherService {

	private static Map<String, Object> jsonToMap(String str) {
		Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
		}.getType());
		return map;
	}

	public static String getOneCityWeather(String city) {

		String cityWeather = "";
		city = city.trim().replace(" ", "+");
		String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="
				+ System.getenv("OW_API_KEY");

		try {

			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			rd.close();

			StringBuilder newResult;
			newResult = result.deleteCharAt(result.indexOf("["));
			newResult = newResult.deleteCharAt(newResult.indexOf("]"));
			Map<String, Object> respMap = jsonToMap(newResult.toString());
			Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());

			String windDirection = String.valueOf(windMap.get("deg"));
			int windDegree = getWindDegree(windDirection);

			switch (windDegree) {
			case 0:
				windDirection = "north";
				break;
			case 90:
				windDirection = "east";
				break;
			case 180:
				windDirection = "south";
				break;
			case 270:
				windDirection = "west";
				break;
			default:
				if (isNorthEast(windDegree)) {
					windDirection = "north east";
				} else if (isSouthEast(windDegree)) {
					windDirection = "south east";
				} else if (isSouthWest(windDegree)) {
					windDirection = "south west";
				} else if (isNorthWest(windDegree)) {
					windDirection = "north west";
				} else {
					windDirection = "error";
				}
			}

			cityWeather = " " + getWeather(newResult) + " and wind " + windDirection + " " + windDegree + "°";

		} catch (IOException e) {
			Logger logger = Logger.getLogger(WeatherService.class.getName());
			logger.log(Level.WARNING, () -> String.valueOf(e));
		}
		return cityWeather;
	}

	private static boolean isNorthEast(int windDegree){
		if (windDegree > 0 && windDegree < 90) {
			return true;
		}
		else {
			return false;
		}
	}

	private static boolean isSouthEast(int windDegree){
		if (windDegree > 90 && windDegree < 180) {
			return true;
		}
		else {
			return false;
		}
	}

	private static boolean isSouthWest(int windDegree){
		if (windDegree > 180 && windDegree < 270) {
			return true;
		}
		else {
			return false;
		}
	}

	private static boolean isNorthWest(int windDegree){
		if (windDegree > 270 && windDegree < 360) {
			return true;
		}
		else {
			return false;
		}
	}

	private static int getWindDegree(String windDirection){
		return Integer.parseInt(windDirection.substring(0, windDirection.length() - 2));
	}

	private static String getWeather(StringBuilder result){
		String des = "\"description\":\"";
		return result.substring(result.indexOf(des) + des.length(),
				result.indexOf("\",\"icon\""));
	}
}
