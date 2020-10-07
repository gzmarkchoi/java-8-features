package com.mci.javaeight.enumexamples;

public class ColorTest {
    ColorEnum color = ColorEnum.RED;

    public void change() {
        switch (color) {
            case RED:
                color = ColorEnum.GREEN;
                break;
            case YELLOW:
                color = ColorEnum.RED;
                break;
            case GREEN:
                color = ColorEnum.YELLOW;
                break;
        }
    }
}

enum ColorEnum {
    GREEN, YELLOW, RED
}
