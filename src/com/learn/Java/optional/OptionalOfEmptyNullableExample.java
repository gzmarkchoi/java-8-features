package com.learn.Java.optional;

import javax.swing.text.html.Option;
import java.sql.SQLOutput;
import java.util.Optional;

public class OptionalOfEmptyNullableExample {

    public static Optional<String> ofNullable() {
        Optional<String> stringOptional = Optional.ofNullable("Hello"); // value could be null
        return stringOptional;
    }

    public static Optional<String> of() {
        Optional<String> stringOptional = Optional.of("Hello"); // value could NOT be null
        return stringOptional;
    }

    public static Optional<String> empty() {

        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println("OfNullable: " + ofNullable());
        System.out.println("Of: " + of());
        System.out.println("Empty: " + empty());
    }

}
