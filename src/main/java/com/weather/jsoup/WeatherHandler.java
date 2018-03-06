package com.weather.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.xml.bind.Element;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.weather.constants.Selectors.*;

/**
 * Created by M.Malyus on 2/27/2018.
 */
public class WeatherHandler {
    private static final String DATE_FORMAT = "EEEE";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public String getMinTemperature(String URL,int day) throws IOException {
        Document doc = Jsoup.connect(URL).get();
        Elements minTemperatureElements = doc.select(MIN_TEMPERATURE_LIST);
        return minTemperatureElements.eq(day).text();
    }
    public String getMaxTemperature(int day,String URL) throws IOException {
        Document doc = Jsoup.connect(URL).get();
        Elements maxTemperatureElements = doc.select(MAX_TEMPERATURE_LIST);
        return maxTemperatureElements.eq(day).text();
    }
    /*Sky status is for week and current day for
     * different parts of day. */
    public String getSkyStatus(int day,String URL) throws IOException {
        Document doc = Jsoup.connect(URL).get();
        Elements skyStatus = doc.select(SKY_LIST);
        return skyStatus.eq(day).attr("title");
    }
    public String getTemperaturePartOfDay(String partOfDay,String URL) throws IOException {
        Document doc = Jsoup.connect(URL).get();
        String todayTemperature = doc.select(partOfDay).text();
        return todayTemperature;
    }
    public String getPressurePartOfDay(String partOfDay,String URL) throws IOException {
        Document doc = Jsoup.connect(URL).get();
        String todayPressure = doc.select(partOfDay).text();
        return todayPressure;
    }
    /*Wind info in attribute 'data-tooltip'*/
    public String getWindPartOfDay(String partOfDay,String URL) throws IOException {
        Document doc = Jsoup.connect(URL).get();
        String todayWind = doc.select(partOfDay).attr("data-tooltip");
        return todayWind;
    }
    public String getDay(String URL, int day,int nextDay) throws IOException {
        /*DAY_NAME cant be parsed so use def library*/
        Document doc = Jsoup.connect(URL).get();
        Elements dayNumber = doc.select(DAY_NUMBER);
        Elements monthName = doc.select(MONTH_NAME);
        Elements dayName = doc.select(DAY_NAME);
        String week = dayNumber.eq(day).text() + " " +  monthName.eq(day).text() + "(" + getNextDay(nextDay) + ")";
        return week;
    }
    /*This method will return next days in format 'EEEE'
    * it means that only name of day of week.Var day is
    * how many days we want to add to current day*/
    public static String getNextDay(int day){
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE,day);
        String nextDay = dateFormat.format(calendar.getTime());
        System.out.println("Next day:" + nextDay);
        return nextDay;
    }
}
