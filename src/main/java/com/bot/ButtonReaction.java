package com.bot;

import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import static java.lang.StrictMath.toIntExact;

/**
 * Created by M.Malyus on 2/26/2018.
 */
public class ButtonReaction {

    public static EditMessageText createResponseForButton(String callbackQuery,String buttonCallbackQuery,String buttonResponse,long chatId,long messageId){
        EditMessageText responseMessage = new EditMessageText();
        if(callbackQuery.equalsIgnoreCase(buttonCallbackQuery)){
            String answer = null;
            answer = buttonResponse;
            responseMessage
                    .setChatId(chatId)
                    .setMessageId(toIntExact(messageId))
                    .setText(answer);

        }
        return responseMessage;
    }

}
