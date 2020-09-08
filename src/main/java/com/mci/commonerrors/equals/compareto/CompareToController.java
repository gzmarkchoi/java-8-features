package com.mci.commonerrors.equals.compareto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareToController {

    public static void main(String[] args) {
        wrong();
        right();
    }

    public static void wrong() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "zhang"));
        list.add(new Student(2, "wang"));
        Student student = new Student(2, "li");

        System.out.println("ArrayList.indexOf");
        int index1 = list.indexOf(student);
        Collections.sort(list);

        System.out.println("Collections.binarySearch");
        int index2 = Collections.binarySearch(list, student);

        System.out.println("index1 = " + index1);
        System.out.println("index2 = " + index2);
    }

    public static void right() {
        List<StudentRight> list = new ArrayList<>();
        list.add(new StudentRight(1, "zhang"));
        list.add(new StudentRight(2, "wang"));
        StudentRight student = new StudentRight(2, "li");

        System.out.println("ArrayList.indexOf");
        int index1 = list.indexOf(student);
        Collections.sort(list);
        System.out.println("Collections.binarySearch");
        int index2 = Collections.binarySearch(list, student);

        System.out.println("index1 = " + index1);
        System.out.println("index2 = " + index2);
    }

    static class Student implements Comparable<Student> {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Student other) {
            int result = Integer.compare(other.id, id);
            if (result == 0)
                System.out.println("this {} == other {}" + this + other);
            return result;
        }
    }

    static class StudentRight implements Comparable<StudentRight> {
        private int id;
        private String name;

        public StudentRight(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(StudentRight other) {
            return Comparator.comparing(StudentRight::getName)
                    .thenComparingInt(StudentRight::getId)
                    .compare(this, other);
        }
    }

}
