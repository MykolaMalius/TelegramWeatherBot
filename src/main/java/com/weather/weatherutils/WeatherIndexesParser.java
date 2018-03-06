package com.weather.weatherutils;

import com.weather.builder.WeatherParserBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.weather.constants.WeatherNodeConstants.*;


/**
 * Created by M.Malyus on 2/22/2018.
 */
public class WeatherIndexesParser {
    private String morningWeatherValue;
    private String dinnerWeatherValue;
    private String eveningWeatherValue;

    public String getTomorrowMorningWeather(int weatherIndexName) throws ParserConfigurationException, SAXException, IOException {
        /*NodeList of next day 11:00 a.m*/
        NodeList tomorrowMorning = WeatherParserBuilder.createDocumentConnection().
                getElementsByTagName(NODE_LIST_TAG_NAME).
                item(TOMORROW_MORNING_NODE).
                getChildNodes();
         /*Temperature node*/
        Node morningTemperatureNode = tomorrowMorning.item(weatherIndexName);
        morningWeatherValue = morningTemperatureNode.getTextContent();
        return morningWeatherValue;
    }
    public String getTomorrowDinnerWeather(int weatherIndexName) throws ParserConfigurationException, SAXException, IOException {
        /*NodeList of next day 17:00*/
        NodeList tomorrowDinnerNodeList = WeatherParserBuilder.createDocumentConnection().
                getElementsByTagName(NODE_LIST_TAG_NAME).
                item(TOMORROW_DINNER_NODE).
                getChildNodes();
         /*Temperature node*/
        Node dinnerTemperatureNode = tomorrowDinnerNodeList.item(weatherIndexName);
        dinnerWeatherValue = dinnerTemperatureNode.getTextContent();
        return dinnerWeatherValue;
    }
    public String getTomorrowEveningWeather(int weatherIndexName) throws ParserConfigurationException, SAXException, IOException {
        /*NodeList of next day 23:00*/
        NodeList tomorrowEvening = WeatherParserBuilder.createDocumentConnection().
                getElementsByTagName(NODE_LIST_TAG_NAME).
                item(TOMORROW_EVENING_NODE).
                getChildNodes();
        /*Temperature node*/
        Node eveningTemperatureNode = tomorrowEvening.item(weatherIndexName);
        eveningWeatherValue = eveningTemperatureNode.getTextContent();
        return eveningWeatherValue;
    }
}
