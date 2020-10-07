package com.mci.javaeight.enumexamples;

/*
    Enum example with toString()
 */
public class EnumTestWithToString {
    public static void main(String[] args) {
        ColorEnum colorEnum = ColorEnum.RED;
        System.out.println(colorEnum.toString());
    }
}

enum ColorEnumWithToString {
    RED("Red", 1),
    GREEN("Green", 2),
    White("White", 3),
    YELLOW("Yellow", 4);

    //  成员变量
    private String name;
    private int index;

    //  构造方法
    private ColorEnumWithToString(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.index + "：" + this.name;
    }
}
