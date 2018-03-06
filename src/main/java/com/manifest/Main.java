package com.manifest;

import com.bot.BotBody;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by M.Malyus on 2/21/2018.
 */
public class Main {
    private static final String DATE_FORMAT = "mmm";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    final static Logger LOG = Logger.getLogger(Main.class);
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try{
            botsApi.registerBot(new BotBody());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        LOG.info("Bot is up");
    }
}
