package com.bot;

import com.manifest.Main;
import com.vdurmont.emoji.EmojiParser;
import com.weather.constants.Messages;
import com.weather.jsoup.WeatherHandler;
import com.weather.utilhandler.CloudCoverHandler;
import com.weather.utilhandler.TemperatureHandler;
import com.weather.utilhandler.WindSpeedHandler;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.io.IOException;

import static com.weather.constants.Messages.*;
import static com.weather.constants.Selectors.MORNING_WIND;

/**
 * Created by M.Malyus on 2/21/2018.
 */
public class BotBody extends TelegramLongPollingBot {
    final static Logger LOG = Logger.getLogger(BotBody.class);
    private String firstUserName;
    private String lastUserName;
    private long userId;
    private String userText;

    private static String URL = "";
    private static String preURL = "https://ua.sinoptik.ua/погода-";
    public static String userCity = "";

    private static boolean activeOfCityButton = false;
    private static boolean activeOfAlarmButton = false;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            /*Write all logs from chat*/
            firstUserName = update.getMessage().getChat().getFirstName();
            lastUserName = update.getMessage().getChat().getLastName();
            userId = update.getMessage().getChat().getId();
            userText = update.getMessage().getText();

            logUser(firstUserName,lastUserName,userId,userText);

            Message updateMessage = update.getMessage();
            SendMessage startMessage = MenuButtons
                    .createMainMenu(updateMessage,DEF_MESSAGE);

            try {
                execute(startMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
            /*Today weather handler*/
            if (update.getMessage().getText().contains("TodayWeather")){
                if(!URL.isEmpty()) {
                    Message message = update.getMessage();
                    try {
                        SendMessage mainMenu = MenuButtons
                                .createMainMenu(message, Messages.getTodayWeatherMessage(URL));
                        try {
                            execute(mainMenu);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                /*If city is not chosen and URL is
                empty bot talk user to write any city*/
                else if(URL.isEmpty()){
                    SendMessage todayWeatherHelpMessage = new SendMessage();
                    todayWeatherHelpMessage.setParseMode("HTML");
                    todayWeatherHelpMessage
                            .setChatId(update.getMessage().getChatId())
                            .setText(TODAY_WEATHER_HELP_MESSAGE);
                    try {
                        execute(todayWeatherHelpMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
            /*Option menu handler*/
            else if (update.getMessage().getText().contains("Option")) {
                Message message = update.getMessage();
                SendMessage optionMenu = MenuButtons.createOptionMenu(message,"Option menu");
                try{
                    execute(optionMenu);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if ("Back".equalsIgnoreCase(update.getMessage().getText())) {
                Message message = update.getMessage();
                SendMessage mainMenu = MenuButtons.createMainMenu(message, "Main menu");
                try{
                    execute(mainMenu);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if(update.getMessage().getText().contains("City")){
                activeOfCityButton = true;
                SendMessage cityMessage = new SendMessage();
                cityMessage.setParseMode("HTML");
                cityMessage.setChatId(update.getMessage().getChatId())
                        .setText("<b>Input your city like:</b>" + "\n" + "<i>Львів</i>");
                try{
                    execute(cityMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            /*This checks if city is not empty,
            * if city is filled with valid city
            * bot can make a weather forecast for today*/
            else if(activeOfCityButton == true){
                activeOfCityButton = false;
                SendMessage cityChangesMessage = new SendMessage();
                cityChangesMessage.setParseMode("HTML");
                cityChangesMessage
                        .setChatId(update.getMessage().getChatId())
                        .setText(CITY_UPDATE_MESSAGE + "<i>" + update.getMessage().getText() + "</i>");
                LOG.info("URL before updating:" + URL);
                userCity = update.getMessage().getText();
                URL = preURL + update.getMessage().getText();
                LOG.info("URL after updating:" + URL);
                try {
                    execute(cityChangesMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            /*WeekForecast handler*/
            else if(update.getMessage().getText().contains("WeekForecast")){
                if(!URL.isEmpty()){
                    SendMessage weekendForecast = new SendMessage();
                    weekendForecast.setParseMode("HTML");
                    try {
                        weekendForecast
                                .setChatId(update.getMessage().getChatId())
                                .setText(Messages.getWeekForecastMessage(URL));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try{
                        execute(weekendForecast);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                /*Also bot checks does user enter any city*/
                else if(URL.isEmpty()){
                    SendMessage emptyCity = new SendMessage();
                    emptyCity.setParseMode("HTML");
                    emptyCity.setChatId(update.getMessage().getChatId())
                            .setText(WEEK_FORECAST_HELP_MESSAGE);
                    try{
                        execute(emptyCity);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

            }
            if(update.getMessage().getText().equalsIgnoreCase("alarm") ){
                activeOfAlarmButton = true;
                SendMessage alarmHelpMessage = new SendMessage()
                        .setParseMode("HTML");
                alarmHelpMessage.setChatId(update.getMessage().getChatId());
                alarmHelpMessage.setText("<i>Write after how many seconds notification will be sent</i>");
                try {
                    execute(alarmHelpMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(activeOfAlarmButton == true){
                activeOfAlarmButton = false;
                String notificationTime = update.getMessage().getText();
                int wait = Integer.parseInt(notificationTime);
                try {
                    Thread.sleep(wait * 1000);
                    SendMessage alarmNotification = new SendMessage()
                            .setParseMode("HTML");
                    alarmNotification
                            .setChatId(update.getMessage().getChatId())
                            .setText("<code>Wake up, Neo..</code>");
                    int x = 0;
                    while (x<1){
                        execute(alarmNotification);
                        LOG.info("Notification has sent");
                        x++;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    public String getBotUsername() {
        return "YusufTazimBot";
    }
    public String getBotToken() {
        return "504366651:AAFce17tEjszVwu2zZFFLPzsTi5zgz8vnz8";
    }
    private void logUser(String firstName,String lastName,long userId,String userText){
        LOG.info("\n-------------------------------");
        LOG.info("Message from " + firstName + lastName + " which Id is:" + userId + ":"+ userText);
    }
}





