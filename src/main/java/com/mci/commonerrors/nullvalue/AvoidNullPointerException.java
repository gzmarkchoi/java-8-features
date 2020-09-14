package com.mci.commonerrors.nullvalue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AvoidNullPointerException {

    public static void main(String[] args) {
        String test = "1111";

        wrongMethod(test.charAt(0) == '1' ? null : new FooService(),
                test.charAt(1) == '1' ? null : 1,
                test.charAt(2) == '1' ? null : "OK",
                test.charAt(3) == '1' ? null : "OK");

        Optional.ofNullable(rightMethod(test.charAt(0) == '1' ? null : new FooService(),
                test.charAt(1) == '1' ? null : 1,
                test.charAt(2) == '1' ? null : "OK",
                test.charAt(3) == '1' ? null : "OK"))
        .orElse(Collections.emptyList()).size();
    }

    private static List<String> wrongMethod(FooService fooService, Integer i, String s, String t) {
        if (fooService.getBarService().bar().equals("OK"))
            System.out.println("bar service OK");
        return null;
    }

    private static List<String> rightMethod(FooService fooService, Integer i, String s, String t) {
        Optional.ofNullable(fooService)
                .map(FooService::getBarService)
                .filter(barService -> "OK".equals(barService.bar()))
                .ifPresent(result -> System.out.println("OK"));

        return new ArrayList<>();
    }

    static class FooService {
        private BarService barService;

        public BarService getBarService() {
            return barService;
        }

        public void setBarService(BarService barService) {
            this.barService = barService;
        }
    }

    class BarService {
        String bar() {
            return "bar OK";
        }
    }
}
