package com.mci.javaeight.dates;

import java.time.LocalDateTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("local date time: " + localDateTime);

        // getting the time and date from LocalDateTime instance
        System.out.println("hour: " + localDateTime.getHour());
        System.out.println("hour: " + localDateTime.getMinute());
        System.out.println("hour: " + localDateTime.getDayOfMonth());
    }

}
