package com.alarm;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by M.Malyus on 3/5/2018.
 */
public class ReminderBeep {
    Toolkit toolkit;

    Timer timer;

    public ReminderBeep(int seconds) {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("5 sec remaining");
            toolkit.beep();
            Desktop desktop = Desktop.getDesktop();
            File file = new File("C:\\Users\\M.Malyus\\Desktop\\2.0.jpeg");
            File editFile = new File("C:\\Users\\M.Malyus\\Desktop\\BuffaloBill");
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //timer.cancel(); //Not necessary because we call System.exit
            System.exit(0); //Stops the AWT thread (and everything else)
        }
    }

}