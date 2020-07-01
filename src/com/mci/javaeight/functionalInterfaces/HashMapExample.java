package com.mci.javaeight.functionalInterfaces;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, String> dbHM = new HashMap<>();
        HashMap<String, String> fileHM = new HashMap<>();

        dbHM.put("1", "A1");
        dbHM.put("2", "A2");
        dbHM.put("3", "A3");

        fileHM.put("2", "A2");
        fileHM.put("3", "A1");
        fileHM.put("4", "A3");

        String idInDB = null;
        String classNameInDB = null;
        String idInFile = null;
        String classNameInFile = null;

        Iterator<Map.Entry<String, String>> dbIt = dbHM.entrySet().iterator();
        while (dbIt.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) dbIt.next();
            idInDB = entry.getKey();
            classNameInDB = entry.getValue();
            if (!fileHM.containsKey((idInDB))) {
                // dbHM.remove(idInDB);
                System.out.println("Need Delete ID: " + idInDB);
            } else {
                classNameInFile = fileHM.get(idInDB);
                if (!classNameInFile.equals(classNameInDB)) {
                    // update
                    System.out.println("Need update ID:" + idInDB);
                }
            }
        }

        Iterator<Map.Entry<String, String>> fileIt = fileHM.entrySet().iterator();
        while (fileIt.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) fileIt.next();
            idInFile = entry.getKey();
            classNameInFile = entry.getValue();
            if (!dbHM.containsKey(idInFile)) {
                // insert this student
                System.out.println("Insert ID:" + idInFile + " class name is: " + classNameInFile);
            }
        }
    }
}
