package com.alten.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger = null;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm:ss");

    private Logger() {

    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String message) {
        LocalDateTime timestamp = LocalDateTime.now();
        System.out.printf("[%s] %s\n", timestamp.format(formatter), message);
    }
}
