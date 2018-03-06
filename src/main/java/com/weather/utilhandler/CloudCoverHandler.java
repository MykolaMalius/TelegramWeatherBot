package com.weather.utilhandler;

import com.weather.weatherutils.WeatherIndexesParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.weather.constants.WeatherNodeConstants.CLOUD_COVER;

/**
 * Created by M.Malyus on 2/23/2018.
 */
public class CloudCoverHandler {
    private WeatherIndexesParser weatherIndexesParser;
    private String cloudCoverValue;

    public String getMorningCloudCoverValue() throws IOException, SAXException, ParserConfigurationException {
        weatherIndexesParser = new WeatherIndexesParser();
        String cloudCover = weatherIndexesParser.getTomorrowMorningWeather(CLOUD_COVER);

        if(Double.parseDouble(cloudCover)>=0 && Double.parseDouble(cloudCover)<15){
            cloudCover = "Tomorrow sky will be clear:" + cloudCover + "%";
        }else if (Double.parseDouble(cloudCover)>=15 && Double.parseDouble(cloudCover)<40){
            cloudCover = "Tomorrow on sky will be a little clouds:" + cloudCover + "%";
        }else if(Double.parseDouble(cloudCover)>=40 && Double.parseDouble(cloudCover)<=80){
            cloudCover = "Tomorrow on sky will be with grey clouds:" + cloudCover +"%";
        }else if(Double.parseDouble(cloudCover)>80 && Double.parseDouble(cloudCover)>=100){
            cloudCover = "Tomorrow sky will be very cloudly:" + cloudCover + "%";
        }
        return cloudCover;
    }
    public String getDinnerCloudCoverValue() throws IOException, SAXException, ParserConfigurationException {
        weatherIndexesParser = new WeatherIndexesParser();
        String cloudCover = weatherIndexesParser.getTomorrowDinnerWeather(CLOUD_COVER);

        if(Double.parseDouble(cloudCover)>=0 && Double.parseDouble(cloudCover)<15){
            cloudCover = "Tomorrow sky will be clear:" + cloudCover + "%";
        }else if (Double.parseDouble(cloudCover)>=15 && Double.parseDouble(cloudCover)<40){
            cloudCover = "Tomorrow on sky will be a little clouds:" + cloudCover + "%";
        }else if(Double.parseDouble(cloudCover)>=40 && Double.parseDouble(cloudCover)<=80){
            cloudCover = "Tomorrow on sky will be with grey clouds:" + cloudCover +"%";
        }else if(Double.parseDouble(cloudCover)>80 && Double.parseDouble(cloudCover)>=100){
            cloudCover = "Tomorrow sky will be very cloudly:" + cloudCover + "%";
        }
        return cloudCover;
    }
    public String getEveningCloudCoverValue() throws IOException, SAXException, ParserConfigurationException {
        weatherIndexesParser = new WeatherIndexesParser();
        String cloudCover = weatherIndexesParser.getTomorrowEveningWeather(CLOUD_COVER);

        if(Double.parseDouble(cloudCover)>=0 && Double.parseDouble(cloudCover)<15){
            cloudCover = "Tomorrow sky will be clear:" + cloudCover + "%";
        }else if (Double.parseDouble(cloudCover)>=15 && Double.parseDouble(cloudCover)<40){
            cloudCover = "Tomorrow sky will be with a little clouds:" + cloudCover + "%";
        }else if(Double.parseDouble(cloudCover)>=40 && Double.parseDouble(cloudCover)<=80){
            cloudCover = "Tomorrow sky will be with grey clouds:" + cloudCover +"%";
        }else if(Double.parseDouble(cloudCover)>80 && Double.parseDouble(cloudCover)>=100){
            cloudCover = "Tomorrow sky will be very cloudly:" + cloudCover + "%";
        }
        return cloudCover;
    }
}
