package com.ui.seleniumutils;

public class WaitUtils {

    public static void waitForSecond(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
