package com.weather.utilhandler;

import com.weather.weatherutils.WeatherIndexesParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.weather.constants.WeatherNodeConstants.WIND_SPEED;

/**
 * Created by M.Malyus on 2/23/2018.
 */
public class WindSpeedHandler {
    private WeatherIndexesParser weatherIndexesParser;
    private String windSpeedValue;

    public String getMorningWindSpeedValue() throws IOException, SAXException, ParserConfigurationException {
        weatherIndexesParser = new WeatherIndexesParser();
        String windSpeed = weatherIndexesParser.getTomorrowMorningWeather(WIND_SPEED);

        if(Double.parseDouble(windSpeed)>=0 && Double.parseDouble(windSpeed)<8){
            windSpeedValue = "Wind will be very weak tomorrow with speed:" + windSpeed + "m/s";
        }else if(Double.parseDouble(windSpeed)>=8 && Double.parseDouble(windSpeed)<13){
            windSpeedValue = "Wind will be strong, tree branch will be tired.Wind speed:" + windSpeed + "m/s";
        }else if(Double.parseDouble(windSpeed)>=14 && Double.parseDouble(windSpeed)<20){
            windSpeedValue = "Wind will be strong tomorrow with speed:" + windSpeed + "m/s";
        }else {
            windSpeedValue = "Hurricane is coming with speed:" + windSpeed + "m/s.Do not leave your home please.";
        }
     return windSpeedValue;
    }
    public String getDinnerWindSpeedValue() throws IOException, SAXException, ParserConfigurationException {
        weatherIndexesParser = new WeatherIndexesParser();
        String windSpeed = weatherIndexesParser.getTomorrowDinnerWeather(WIND_SPEED);

        if(Double.parseDouble(windSpeed)>=0 && Double.parseDouble(windSpeed)<8){
            windSpeedValue = "Wind will be very weak tomorrow with speed:" + windSpeed + "m/s";
        }else if(Double.parseDouble(windSpeed)>=8 && Double.parseDouble(windSpeed)<13){
            windSpeedValue = "Wind will be strong, tree branch will be tired.Wind speed:" + windSpeed + "m/s";
        }else if(Double.parseDouble(windSpeed)>=14 && Double.parseDouble(windSpeed)<20){
            windSpeedValue = "Wind will be strong tomorrow with speed:" + windSpeed + "m/s";
        }else {
            windSpeedValue = "Hurricane is coming with speed:" + windSpeed + "m/s.Do not leave your home please.";
        }
        return windSpeedValue;
    }
    public String getEveningWindSpeedValue() throws IOException, SAXException, ParserConfigurationException {
        weatherIndexesParser = new WeatherIndexesParser();
        String windSpeed = weatherIndexesParser.getTomorrowEveningWeather(WIND_SPEED);

        if(Double.parseDouble(windSpeed)>=0 && Double.parseDouble(windSpeed)<8){
            windSpeedValue = "Wind will be very weak tomorrow with speed:" + windSpeed + "m/s";
        }else if(Double.parseDouble(windSpeed)>=8 && Double.parseDouble(windSpeed)<13){
            windSpeedValue = "Wind will be strong, tree branch will be tired.Wind speed:" + windSpeed + "m/s";
        }else if(Double.parseDouble(windSpeed)>=14 && Double.parseDouble(windSpeed)<20){
            windSpeedValue = "Wind will be strong tomorrow with speed:" + windSpeed + "m/s";
        }else {
            windSpeedValue = "Hurricane is coming with speed:" + windSpeed + "m/s.Do not leave your home please.";
        }
        return windSpeedValue;
    }
}
