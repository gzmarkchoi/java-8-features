package com.mci.commonerrors.equals.intandstringequal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntAndStringEqualController {

    /*
        注意 equals 和 == 的区别
        在业务代码中，我们通常使用 equals 或 == 进行判等操作。equals 是方法而 == 是操作符，它们的使用是有区别的：
            - 对基本类型，比如 int、long，进行判等，只能使用 ==，比较的是直接值。因为基本类型的值就是其数值。
            - 对引用类型，比如 Integer、Long 和 String，进行判等，需要使用 equals 进行内容判等。因为引用类型的直接值是指针，
              使用 == 的话，比较的是指针，也就是两个对象在内存中的地址，即比较它们是不是同一个对象，而不是比较对象的内容。
     */

    // 比较值的内容，除了基本类型只能使用 == 外，其他类型都需要使用 equals。
    public static void main(String[] args) {
        stringCompare();
        internPerformance(10000);
        intCompare();
    }

    public static void stringCompare() {
        String a = "1";
        String b = "1";
        System.out.println("String a = \"1\"; b = \"1\";");
        System.out.println(a == b); //true

        String c = new String("2");
        String d = new String("2");
        System.out.println("String c = new String(\"2\"); String d = new String(\"2\");");
        System.out.println(c == d); //false

        /*
            使用 String 提供的 intern 方法也会走常量池机制，所以同样能得到 true

            虽然使用 new 声明的字符串调用 intern 方法，也可以让字符串进行驻留，但在业务代码中滥用 intern，可能会产生性能问题。
         */
        String e = new String("3").intern();
        String f = new String("3").intern();
        System.out.println("String e = new String(\"3\").intern(); String f = new String(\"3\").intern();");
        System.out.println(e == f); //true

        String g = new String("4");
        String h = new String("4");
        System.out.println("String g = new String(\"4\"); String h = new String(\"4\");");
        System.out.println(g.equals(h)); //true

    }

    /*
        没事别轻易用 intern，如果要用一定要注意控制驻留的字符串的数量，并留意常量表的各项指标。
     */
    public static int internPerformance(int size) {
        //-XX:+PrintStringTableStatistics
        //-XX:StringTableSize=10000000

        List<String> list = new ArrayList<>();

        long begin = System.currentTimeMillis();
        list = IntStream.rangeClosed(1, size)
                .mapToObj(i -> String.valueOf(i).intern())
                .collect(Collectors.toList());
        System.out.println("size: " + size );
        System.out.println("took: " + Long.valueOf(System.currentTimeMillis() - begin));

        return list.size();
    }

    public static void intCompare() {
        Integer a = 127; //Integer.valueOf(127)
        Integer b = 127; //Integer.valueOf(127)
        System.out.println("Integer a = 127; Integer b = 127;");
        System.out.println(a == b); //true

        Integer c = 128; //Integer.valueOf(128)
        Integer d = 128; //Integer.valueOf(128)
        System.out.println("Integer c = 128; Integer d = 128;");
        System.out.println(c == d); //false
        //设置-XX:AutoBoxCacheMax=1000再试试

        Integer e = 127; //Integer.valueOf(127)
        Integer f = new Integer(127); //new instance
        System.out.println("Integer e = 127; Integer f = new Integer(127);");
        System.out.println(e == f); //false

        Integer g = new Integer(127); //new instance
        Integer h = new Integer(127); //new instance
        System.out.println("Integer g = new Integer(127); Integer h = new Integer(127);");
        System.out.println(g == h); //false

        Integer i = 128; //unbox
        int j = 128;
        System.out.println("Integer i = 128; int j = 128;");
        System.out.println(i == j); //true

    }
}
