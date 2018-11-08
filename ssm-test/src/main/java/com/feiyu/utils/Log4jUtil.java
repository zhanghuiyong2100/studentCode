package com.feiyu.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author 章辉勇
 * @创建时间 2018年11月07日
 * @描述: log4j2工具类
 **/

public class Log4jUtil {
    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void trace(final String message) {
        logger.trace(message);
    }

    public static void debug(final String message) {
        logger.debug(message);
    }

    public static void info(final String message) {
        logger.info(message);
    }

    public static void error(final String message) {
        logger.error(message);
    }

    public static void warn(final String message) {
        logger.warn(message);
    }

    public static void fatal(final String message) {
        logger.fatal(message);
    }


    public static void main(String[] args) {
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.error("error level");
        logger.warn("warn level");
        logger.fatal("fatal level");
        logger.error("看看罗");
    }


}
