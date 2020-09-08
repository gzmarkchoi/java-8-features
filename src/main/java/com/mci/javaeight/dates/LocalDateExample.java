package com.mci.javaeight.dates;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("local date: " + LocalDate.of(2018, 07, 17));

        System.out.println("get month: " + localDate.getMonth());
        System.out.println("temporal adjusters: " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("chronounit minus: " + localDate.minus(1, ChronoUnit.YEARS));

        // additional support methods
        System.out.println("leap year: " + LocalDate.ofYearDay(2020, 01).isLeapYear());
    }
}
