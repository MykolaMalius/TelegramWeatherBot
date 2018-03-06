package com.weather.constants;

/**
 * Created by M.Malyus on 2/27/2018.
 */
public class Selectors {
    /*Week list.Sky list includes also for 2:00 - 23:00*/
    public final static String MIN_TEMPERATURE_LIST = "div.temperature > div.min > span";
    public final static String MAX_TEMPERATURE_LIST = "div.temperature > div.max > span";
    public final static String SKY_LIST = "div[class*='weatherIco']";

    public final static String MORNING_TEMPERATURE = "tbody > tr.temperature > td.p3";
    public final static String DINNER_TEMPERATURE = "tbody > tr.temperature > td.p5.cur";
    public final static String EVENING_TEMPERATURE = "tbody > tr.temperature > td.p7";

    public final static String MORNING_PRESSURE = "tbody > tr:nth-child(5) > td.p3";
    public final static String DINNER_PRESSURE = "tbody > tr:nth-child(5) > td.p5.cur";
    public final static String EVENING_PRESSURE = "tbody > tr:nth-child(5) > td.p7";
    /*Value of wind info is in attribute: 'data-tooltip'*/
    public final static String MORNING_WIND = "tbody > tr:nth-child(7) > td.p3 > div";
    public final static String DINNER_WIND = "tbody > tr:nth-child(7) > td.p5 > div";
    public final static String EVENING_WIND = "tbody > tr:nth-child(7) > td.p7 > div";

    public final static String DAY_NUMBER = "p.date";
    public final static String DAY_NAME = "p.day-link";
    public final static String MONTH_NAME = "p.month";

}
