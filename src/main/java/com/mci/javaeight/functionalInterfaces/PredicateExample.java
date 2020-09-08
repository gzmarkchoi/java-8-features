package com.mci.javaeight.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {
    static Predicate<Integer> predicate1 = (integer -> integer % 2 == 0);

    static Predicate<Integer> predicate2 = (integer -> integer % 5 == 0);

    public static void predicateAnd() {
        System.out.println("Predicate AND result is: " + predicate1.and(predicate2).test(10));
        System.out.println("Predicate AND result is: " + predicate1.and(predicate2).test(9));
    }

    public static void predicateOr() {
        System.out.println("Predicate OR result is: " + predicate1.or(predicate2).test(10));
        System.out.println("Predicate OR result is: " + predicate1.or(predicate2).test(8));
    }

    public static void predicateNegate() {
        System.out.println("Predicate NEGATE result is: " + predicate1.or(predicate2).negate().test(8));
    }

    public static void main(String[] args) {

        System.out.println(predicate1.test(4));

        predicateAnd();
        predicateOr();
        predicateNegate();
    }
}
