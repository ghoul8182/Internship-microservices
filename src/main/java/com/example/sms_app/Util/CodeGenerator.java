package com.example.sms_app.Util;

public class CodeGenerator {

    public static String generateRandomCode() {
        return String.valueOf((int)(Math.random() * 900000) + 100000);
    }

}
