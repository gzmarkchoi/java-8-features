package com.mci.javaeight.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeExample {

    public static void main(String[] args) {
        // local date

        System.out.println("local date: " + LocalDate.now());

        System.out.println("local time: " + LocalTime.now());

        System.out.println("local date time: " + LocalDateTime.now());
    }
}
