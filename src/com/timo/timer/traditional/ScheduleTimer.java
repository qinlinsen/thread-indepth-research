package com.timo.timer.traditional;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduleTimer {
    public static void everyPerPeriodExecute(int millionSeconds){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        }, millionSeconds,1000);
    }

    public static void main(String[] args) {
        everyPerPeriodExecute(1);
    }
}
