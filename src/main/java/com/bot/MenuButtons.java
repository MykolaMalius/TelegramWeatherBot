package com.bot;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Malyus on 2/28/2018.
 */
public class MenuButtons {
    final static String sunny = EmojiParser.parseToUnicode(":sunny:");
    final static String forecast = EmojiParser.parseToUnicode(":partly_sunny:");
    final static String option = EmojiParser.parseToUnicode(":open_file_folder:");
    final static String city = EmojiParser.parseToUnicode(":house:");


    public static SendMessage createMainMenu(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        //Create our keyboard
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setParseMode("HTML");
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        //Create list of keyboards
        List<KeyboardRow> keyboard = new ArrayList<>();

        //First line of buttons
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        //Add buttons for first line
        keyboardFirstRow.add(sunny + "TodayWeather");
        keyboardFirstRow.add(forecast + "WeekForecast");

        //Second line of buttons
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        //Add buttons for second line
        keyboardSecondRow.add(option + "Option");
        keyboardSecondRow.add(city + "City");

        //Add all buttons to keyboard-list
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        //set our list
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        return sendMessage;
    }
    public static SendMessage createOptionMenu(Message message,String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add("Option");
        keyboardFirstRow.add("Option 2");

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("Alarm");
        keyboardSecondRow.add("Back");

        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);

        return sendMessage;
    }

}
