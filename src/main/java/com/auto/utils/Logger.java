package com.auto.utils;

import io.qameta.allure.Allure;
import org.slf4j.LoggerFactory;

public class Logger {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    public static void info(String message) {
        logger.info(message);
        logToAllure("INFO", message);
    }

    public static void error(String message) {
        logger.error(message);
        logToAllure("ERROR", message);
    }

    public static void warn(String message) {
        logger.warn(message);
        logToAllure("WARN", message);
    }

    private static void logToAllure(String level, String message) {
        String logMessage = String.format("[%s] %s", level, message);
        Allure.getLifecycle().addAttachment("Log Entry", "text/plain", "txt", logMessage.getBytes());
    }
}
