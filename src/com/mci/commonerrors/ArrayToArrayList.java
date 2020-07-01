package com.mci.commonerrors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToArrayList {

    public static void main(String[] args) {

        // wrong way
        List<String> list = Arrays.asList("one", "two", "three", "four");
        /*
            Arrays.asList() returns a java.util.Arrays.ArrayList, not a java.util.ArrayList;
            it would throw an UnsupportedOperationException
         */
        // list.add("five");

        // right way
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("one", "two"));
        arrayList.add("three");

        System.out.println(arrayList.toString());
    }
}
