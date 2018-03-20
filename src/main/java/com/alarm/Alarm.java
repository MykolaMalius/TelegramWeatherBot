package com.alarm;

import com.bot.BotBody;
import org.apache.log4j.Logger;
import sun.nio.ch.SelectorImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by M.Malyus on 3/15/2018.
 */
public class Alarm extends Thread {
    final static Logger LOG = Logger.getLogger(Alarm.class);
    public static String time;

    public static String check;

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public void createAlarm(){
        Alarm alarm = new Alarm();
        alarm.setCheck("false");
        while (true){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("m");
            String currentTime = simpleDateFormat.format(new Date());
            if (currentTime.equalsIgnoreCase(alarm.getTime())){
                alarm.setCheck("true");
                LOG.info("Alarm, time is up");
                LOG.info("Check value is:" + alarm.getCheck());
                break;
            }
        }
    }

    public void startAlarmThread(){
        Alarm alarm = new Alarm();
        alarm.start();
    }

    @Override
    public void run() {
        Alarm alarm = new Alarm();
        alarm.createAlarm();
    }
}
