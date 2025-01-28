//package org.example.logging;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//public class LoggerUtil {
//    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
//
//    public static void logAddEmployee(String employeeName) {
//        logger.info("Added employee: " + employeeName);
//    }
//
//    public static void logRetrieveEmployee(int id, String employeeName) {
//        logger.info("Retrieved employee with ID " + id + ": " + employeeName);
//    }
//
//    public static void logUpdateEmployee(int id, String newName) {
//        logger.info("Updated employee with ID " + id + " to new name: " + newName);
//    }
//}


//package org.example.logging;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class LoggerUtil {
//
//    // Create a Logger instance
//    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
//
//    public static void logInfo(String message) {
//        logger.info(message);
//    }
//
//    public static void logError(String message, Exception e) {
//        logger.error(message, e);
//    }
//}

//package org.example.logging;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class LoggerUtil {
//    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
//
//    public static void logInfo(String message) {
//        logger.info(message);
//    }
//}

package org.example.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerUtil {
    private static final String LOG_FILE = "logs/application.log";

    public static void log(String level, String message) {
        String logMessage = "[" + LocalDateTime.now() + "] [" + level + "] " + message;
        System.out.println(logMessage);
        writeToFile(logMessage);
    }

    public static void log(String level, String message, Exception e) {
        String logMessage = "[" + LocalDateTime.now() + "] [" + level + "] " + message + " - Exception: " + e.getMessage();
        System.out.println(logMessage);
        writeToFile(logMessage);
    }

    private static void writeToFile(String logMessage) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logMessage + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }
}
