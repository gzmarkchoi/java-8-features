package com.mci.commonerrors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DeleteElementsInAList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));

        /*
            wrong way
         */
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        /*
            output is [b, d]
         */
        System.out.println(list);

        /*
            right way using Iterator
         */
        list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String stringTmp = iter.next();
            if (stringTmp.equals("a")) {
                iter.remove();
            }
        }
        System.out.println(list);

        /*
            wrong way, it throws the ConcurrentModificationException,
            next() is called before remove()
         */
        list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
        for (String s : list) {
            if (s.equals("a")) {
                list.remove(s);
            }
        }

        System.out.println(list);

    }
}
