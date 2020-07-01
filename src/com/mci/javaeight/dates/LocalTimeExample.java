package com.mci.javaeight.dates;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeExample {

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();

        System.out.println("localtime: " + localTime);
        System.out.println("localtime of: " + LocalTime.of(22, 33));

        // getting the values from local time instance
        System.out.println("get hour of local time: " + localTime.getHour());
        System.out.println("chronofield clock hour of day: " + localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));

        System.out.println("local time minus hours:" + localTime.minusHours(2));
    }
}
