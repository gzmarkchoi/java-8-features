package com.mci.javaeight.dates;

import java.time.LocalDate;
import java.time.Period;

public class ComparingDatesPeriodExample {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(2018, 01, 01);
        LocalDate localDate2 = LocalDate.of(2019,04,01);

        Period period = localDate1.until(localDate2);
        System.out.println("get days: " + period.getDays());
        System.out.println("get months: " + period.getMonths());
        System.out.println("get years: " + period.getYears());

        Period period3 = Period.between(localDate1, localDate2);
        System.out.println("period between: " + period3.getYears());
    }
}
