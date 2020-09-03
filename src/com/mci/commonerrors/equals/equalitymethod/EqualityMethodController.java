package com.mci.commonerrors.equals.equalitymethod;

import java.util.HashSet;
import java.util.Objects;

public class EqualityMethodController {

    public static void main(String[] args) {
        wrongEqual1();
        wrongEqual2();
        rightEqual();
    }

    public static void wrongEqual1() {
        System.out.println("------------------ wrong equal ------------------");
        Point p1 = new Point(1, 2, "a");
        Point p2 = new Point(1, 2, "a");
        Point p3 = new Point(1, 2, "a");

        /*
            通过 equals 方法比较 p1 和 p2、p1 和 p3 均得到 false，原因正如刚才所说，我们并没有为 Point 类实现自定义的 equals 方法，
            Object 超类中的 equals 默认使用 == 判等，比较的是对象的引用。
         */
        System.out.println("Wrong equal case 1");
        System.out.println("p1.equals(p2)");
        System.out.println(p1.equals(p2)); //false
        System.out.println("p1.equals(p3)");
        System.out.println(p1.equals(p3)); //false

    }

    public static void wrongEqual2() {
        System.out.println("------------------ wrong equal ------------------");
        PointWrong p1 = new PointWrong(1, 2, "a");
        try {
            System.out.println("p1.equals(null)");
            System.out.println(p1.equals(null)); // NullPointerException
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        Object o = new Object();
        try {
            System.out.println("p1.equals(expression)");
            System.out.println(p1.equals(o)); // type conversion exception
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        PointWrong p2 = new PointWrong(1, 2, "b");
        System.out.println("p1.equals(p2)");
        System.out.println(p1.equals(p2)); //true

        /*
            出现这个 Bug 的原因是，散列表需要使用 hashCode 来定位元素放到哪个桶。如果自定义对象没有实现自定义的 hashCode 方法，
            就会使用 Object 超类的默认实现，得到的两个 hashCode 是不同的，导致无法满足需求。
         */

        HashSet<PointWrong> points = new HashSet<>();
        points.add(p1);
        System.out.println("points.contains(p2)");
        System.out.println(points.contains(p2)); //false
    }

    public static void rightEqual() {
        System.out.println("------------------ right equal ------------------");
        PointRight p1 = new PointRight(1, 2, "a");
        try {
            System.out.println("p1.equals(null)");
            System.out.println(p1.equals(null));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        Object o = new Object();
        try {
            System.out.println("p1.equals(expression)");
            System.out.println(p1.equals(o));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        PointRight p2 = new PointRight(1, 2, "b");
        System.out.println("p1.equals(p2)");
        System.out.println(p1.equals(p2));

        HashSet<PointRight> points = new HashSet<>();
        points.add(p1);
        System.out.println("points.contains(p2)");
        System.out.println(points.contains(p2));
    }

    static class Point {
        private final String desc;
        private int x;
        private int y;

        public Point(int x, int y, String desc) {
            this.x = x;
            this.y = y;
            this.desc = desc;
        }
    }

    static class PointWrong {
        private final String desc;
        private int x;
        private int y;

        public PointWrong(int x, int y, String desc) {
            this.x = x;
            this.y = y;
            this.desc = desc;
        }

        @Override
        public boolean equals(Object o) {
            PointWrong that = (PointWrong) o;
            return x == that.x && y == that.y;
        }
    }

    static class PointRight {
        private final int x;
        private final int y;
        private final String desc;

        public PointRight(int x, int y, String desc) {
            this.x = x;
            this.y = y;
            this.desc = desc;
        }

        /*
            - 考虑到性能，可以先进行指针判等，如果对象是同一个那么直接返回 true；
            - 需要对另一方进行判空，空对象和自身进行比较，结果一定是 fasle；
            - 需要判断两个对象的类型，如果类型都不同，那么直接返回 false；
            - 确保类型相同的情况下再进行类型强制转换，然后逐一判断所有字段。
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointRight that = (PointRight) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
