package com.weather.constants;

import com.vdurmont.emoji.EmojiParser;
import com.weather.jsoup.WeatherHandler;

import java.io.IOException;


import static com.bot.BotBody.userCity;
import static com.weather.constants.Selectors.MORNING_WIND;

/**
 * Created by M.Malyus on 3/6/2018.
 */
public class Messages {
    private static WeatherHandler weatherHandler = new WeatherHandler();
    final static String wind = EmojiParser.parseToUnicode(":dash:");
    final static String cloud = EmojiParser.parseToUnicode(":cloud:");
    final static String snow = EmojiParser.parseToUnicode(":snowflake:");

    public static String getWeekForecastMessage(String URL) throws IOException {
        String weekForecast = "<b>" + weatherHandler.getDay(URL,0,0) + "</b>" + "\n"  +
                "<i>-Min temperature:</i>" + weatherHandler.getMinTemperature(URL, 0) + "\n" +
                "<i>-Max temperature:</i>" + weatherHandler.getMaxTemperature(0,URL) + "\n" +
                "<i>-Forecast:</i>" + weatherHandler.getSkyStatus(0,URL) + "\n" + "\n" +

                "<b>" + weatherHandler.getDay(URL,1,1) + "</b>" + "\n"  +
                "<i>-Min temperature:</i>" + weatherHandler.getMinTemperature(URL, 1) + "\n" +
                "<i>-Max temperature:</i>" + weatherHandler.getMaxTemperature(1,URL) + "\n" +
                "<i>-Forecast:</i>" + weatherHandler.getSkyStatus(1,URL) + "\n" + "\n" +

                "<b>" + weatherHandler.getDay(URL,2,2) + "</b>" + "\n" +
                "<i>-Min temperature:</i>" + weatherHandler.getMinTemperature(URL, 2) + "\n" +
                "<i>-Max temperature:</i>" + weatherHandler.getMaxTemperature(2,URL) + "\n" +
                "<i>-Forecast:</i>" + weatherHandler.getSkyStatus(2,URL) + "\n" + "\n" +

                "<b>" + weatherHandler.getDay(URL,3,3) + "</b>" + "\n" +
                "<i>-Min temperature:</i>" + weatherHandler.getMinTemperature(URL, 3) + "\n" +
                "<i>-Max temperature:</i>" + weatherHandler.getMaxTemperature(0,URL) + "\n" +
                "<i>-Forecast:</i>" + weatherHandler.getSkyStatus(3,URL) + "\n" + "\n" +

                "<b>" + weatherHandler.getDay(URL,4,4) + "</b>" + "\n"  +
                "<i>-Min temperature:</i>" + weatherHandler.getMinTemperature(URL, 4) + "\n" +
                "<i>-Max temperature:</i>" + weatherHandler.getMaxTemperature(4,URL) + "\n" +
                "<i>-Forecast:</i>" + weatherHandler.getSkyStatus(4,URL) + "\n" + "\n" +

                "<b>" + weatherHandler.getDay(URL,5,5) + "</b>" + "\n" +
                "<i>-Min temperature:</i>" + weatherHandler.getMinTemperature(URL, 5) + "\n" +
                "<i>-Max temperature:</i>" + weatherHandler.getMaxTemperature(5,URL) + "\n" +
                "<i>-Forecast:</i>" + weatherHandler.getSkyStatus(5,URL) + "\n" + "\n";
        return weekForecast;
    }
    public static String getTodayWeatherMessage(String URL) throws IOException {
        String todayWeather = "<b>Weather in:</b>" + "<b>" + userCity  +"</b>" + "\n" +
                "<b>Min temperature:</b>" + weatherHandler.getMinTemperature(URL, 0) + "\n" +
                "<b>Max temperature:</b>" + weatherHandler.getMaxTemperature(0, URL) + "\n" +
                "<b>Forecast:</b>" + weatherHandler.getSkyStatus(0, URL) + cloud + snow + "\n" +
                "<b>Wind speed and direction:</b>" + weatherHandler.getWindPartOfDay(MORNING_WIND, URL) + " " + wind;
        return todayWeather;
    }
}
