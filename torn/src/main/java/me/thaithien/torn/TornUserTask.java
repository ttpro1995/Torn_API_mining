package me.thaithien.torn;

import java.util.TimerTask;


public class TornUserTask extends TimerTask {
    @Override
    public void run() {
        TornLogger tornLogger = TornLogger.getInstance();
        tornLogger.getUser();
    }
}
