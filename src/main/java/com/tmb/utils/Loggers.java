package com.tmb.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loggers {

	    private static final Logger logger = LogManager.getLogger(Loggers.class);

	    // Info level log
	    public static void info(String message) {
	        logger.info(message);
	    }

	    // Debug level log
	    public static void debug(String message) {
	        logger.debug(message);
	    }

	    // Error level log
	    public static void error(String message) {
	        logger.error(message);
	    }

	    // Error level log with exception
	    public static void error(String message, Throwable throwable) {
	        logger.error(message, throwable);
	    }

}
