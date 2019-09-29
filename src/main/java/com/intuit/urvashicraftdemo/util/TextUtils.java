package com.intuit.urvashicraftdemo.util;

public class TextUtils {

    public static boolean isEmpty(String str) {
        if (str != null && str.trim().length() > 0) {
            return false;
        }
        return true;
    }
}