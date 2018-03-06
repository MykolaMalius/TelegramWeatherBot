package com.weather.utilhandler;

import com.weather.weatherutils.WeatherIndexesParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.weather.constants.WeatherNodeConstants.TEMPERATURE;

/**
 * Created by M.Malyus on 2/22/2018.
 */
public class TemperatureHandler {
    private WeatherIndexesParser weatherIndexesParser;
    private String temperatureValue;

    public String getMorningTemperatureValue() throws IOException, SAXException, ParserConfigurationException {
        weatherIndexesParser = new WeatherIndexesParser();
        String temperature = weatherIndexesParser.getTomorrowMorningWeather(TEMPERATURE);

        if(Double.parseDouble(temperature)<0 && Double.parseDouble(temperature)> -10){
            temperatureValue = "It will be frost tomorrow with temperature:" + temperature + "°C.Please dress up warmer.";
        }else if(Double.parseDouble(temperature)<-10){
            temperatureValue = "It will be fucking cold tomorrow with temperature:" + temperature + "°C.Do not leave your home" +
                    " without necessary.";
        }else if(Double.parseDouble(temperature)>0 && Double.parseDouble(temperature)<15){
            temperatureValue = "It will be cool tomorrow with temperature:" + temperature + "°C.Dress up a jacket.";
        }else if(Double.parseDouble(temperature)>15 && Double.parseDouble(temperature)<25){
            temperatureValue = "It will be warm tomorrow with temperature:" + temperature + "°C.Leave your jacket at home.";
        }else if(Double.parseDouble(temperature)> 25){
            temperatureValue = "It will be very hot tomorrow with temperature:" + temperature + "°C.Wear your hawaiian shirt.";
        }else if(Double.parseDouble(temperature)<-20){
            temperatureValue = "It will be like in Siberia with temperature:" + temperature + "°C.Burn your house to stay leave.";
        }
        return temperatureValue;
    }
    public String getDinnerTemperatureValue() throws IOException, SAXException, ParserConfigurationException {
        weatherIndexesParser = new WeatherIndexesParser();
        String temperature = weatherIndexesParser.getTomorrowDinnerWeather(TEMPERATURE);

        if(Double.parseDouble(temperature)<0 && Double.parseDouble(temperature)> -10){
            temperatureValue = "It will be frost tomorrow with temperature:" + temperature + "°C.Please dress up warmer.";
        }else if(Double.parseDouble(temperature)<-10){
            temperatureValue = "It will be fucking cold tomorrow with temperature:" + temperature + "°C.Do not leave your home" +
                    " without necessary.";
        }else if(Double.parseDouble(temperature)>0 && Double.parseDouble(temperature)<15){
            temperatureValue = "It will be cool tomorrow with temperature:" + temperature + "°C.Dress up a jacket.";
        }else if(Double.parseDouble(temperature)>15 && Double.parseDouble(temperature)<25){
            temperatureValue = "It will be warm tomorrow with temperature:" + temperature + "°C.Leave your jacket at home.";
        }else if(Double.parseDouble(temperature)> 25){
            temperatureValue = "It will be very hot tomorrow with temperature:" + temperature + "°C.Wear your hawaiian shirt.";
        }else if(Double.parseDouble(temperature)<-20){
            temperatureValue = "It will be like in Siberia with temperature:" + temperature + "°C.Burn your house to stay leave.";
        }
        return temperatureValue;
    }
    public String getEveningTemperatureValue() throws IOException, SAXException, ParserConfigurationException {
        weatherIndexesParser = new WeatherIndexesParser();
        String temperature = weatherIndexesParser.getTomorrowEveningWeather(TEMPERATURE);

        if(Double.parseDouble(temperature)<0 && Double.parseDouble(temperature)> -10){
            temperatureValue = "It will be frost tomorrow with temperature:" + temperature + "°C.Please dress up warmer.";
        }else if(Double.parseDouble(temperature)<-10){
            temperatureValue = "It will be fucking cold tomorrow with temperature:" + temperature + "°C.Do not leave your home" +
                    " without necessary.";
        }else if(Double.parseDouble(temperature)>0 && Double.parseDouble(temperature)<15){
            temperatureValue = "It will be cool tomorrow with temperature:" + temperature + "°C.Dress up a jacket.";
        }else if(Double.parseDouble(temperature)>15 && Double.parseDouble(temperature)<25){
            temperatureValue = "It will be warm tomorrow with temperature:" + temperature + "°C.Leave your jacket at home.";
        }else if(Double.parseDouble(temperature)> 25){
            temperatureValue = "It will be very hot tomorrow with temperature:" + temperature + "°C.Wear your hawaiian shirt.";
        }else if(Double.parseDouble(temperature)<-20){
            temperatureValue = "It will be like in Siberia with temperature:" + temperature + "°C.Burn your house to stay leave.";
        }
        return temperatureValue;
    }
}
