package com.auto.utils;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {

    public static void info(String message) {
        log.info(message);
        logToAllure("INFO", message);
    }

    public static void error(String message) {
        log.error(message);
        logToAllure("ERROR", message);
    }

//    public static void error(String message, Objects... objects) {
//        log.error(message);
//        logToAllure("ERROR", message);
//    }

    public static void warn(String message) {
        log.warn(message);
        logToAllure("WARN", message);
    }

    public static void warn(String message, Object object) {
        log.warn(message,object);
        logToAllure("WARN", message);
    }

    private static void logToAllure(String level, String message) {
        String logMessage = String.format("[%s] %s", level, message);
        Allure.getLifecycle().addAttachment("Log Entry", "text/plain", "txt", logMessage.getBytes());
    }

    public static void error(String message, String fullName, String value) {
        log.error(message);
        logToAllure("ERROR", message);
    }
    public static void error(String message, String string1) {
        log.error(message);
        logToAllure("ERROR", message);
    }

}
