package com.mci.commonerrors.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AsList {

    public static void main(String[] args) {
        wrong1();
        right1();
        wrong2();
        right2();
    }

    /*
        - 不能直接使用 Arrays.asList 来转换基本类型数组
     */
    private static void wrong1() {
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);

        // 只能是把 int 装箱为 Integer，不可能把 int 数组装箱为 Integer 数组
        System.out.println("Arrays.asList() using int");
        System.out.println("list: " + list);
        System.out.println("size: " + list.size());
        System.out.println("class: " + list.get(0).getClass());
    }

    private static void right1() {
        int[] arr1 = {1, 2, 3};
        List list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());

        System.out.println("Arrays.asList() using int with Arrays.stream");
        System.out.println("list: " + list1);
        System.out.println("size: " + list1.size());
        System.out.println("class: " + list1.get(0).getClass());

        Integer[] arr2 = {1, 2, 3};
        List list2 = Arrays.asList(arr2);

        System.out.println("Arrays.asList() using Integer");
        System.out.println("list: " + list2);
        System.out.println("size: " + list2.size());
        System.out.println("class: " + list2.get(0).getClass());
    }

    /*
        - Arrays.asList 返回的 List 不支持增删操作
          Arrays.asList 返回的 List 并不是我们期望的 java.util.ArrayList，而是 Arrays 的内部类 ArrayList
        - 对原始数组的修改会影响到我们获得的那个 List
     */
    private static void wrong2() {
        String[] arr = {"1", "2", "3"};
        List list = Arrays.asList(arr);
        arr[1] = "4";
        try {
            list.add("5"); // UnsupportedOperationException()
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("wrong usage Arrays.asList()");
        System.out.println("arr: " + Arrays.toString(arr)); // [1, 4, 3]
        System.out.println("list: " + list); // [1, 4, 3]
    }

    private static void right2() {
        String[] arr = {"1", "2", "3"};
        List list = new ArrayList(Arrays.asList(arr));
        arr[1] = "4";
        try {
            list.add("5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("right usage Arrays.asList()");
        System.out.println("arr: " + Arrays.toString(arr)); // [1, 4, 3]
        System.out.println("list: " + list); // [1, 2, 3, 5]
    }
}
