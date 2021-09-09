package com.controltower.service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WeatherService {

    private static Map<String, Object> jsonToMap(String str) {
        return new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
    }

    public static String getOneCityWeather(String city) {
        String cityWeather = "";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city.trim().replace(" ", "+") + "&appid="
                + System.getenv("OW_API_KEY");
        return getWeather(getFullResult(urlString))
                + " and wind "
                + WindDirection.getWindDirection(WindDegree.getWindDegree(getWindInformation(getFullResult(urlString))))
                + " "
                + WindDegree.getWindDegree(getWindInformation(getFullResult(urlString)))
                + "°";
    }

    private static String getWindInformation(StringBuilder result) {
        Map<String, Object> respMap = jsonToMap(result.toString());
        Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
        return String.valueOf(windMap.get("deg"));
    }

    private static String getWeather(StringBuilder result) {
        String des = "\"description\":\"";
        return result.substring(result.indexOf(des) + des.length(),
                result.indexOf("\",\"icon\""));
    }

    private static StringBuilder getFullResult(String urlString) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            result.deleteCharAt(result.indexOf("["));
            result.deleteCharAt(result.indexOf("]"));
            rd.close();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(WeatherService.class.getName());
            logger.log(Level.WARNING, () -> String.valueOf(e));
        }
        return result;
    }
}
