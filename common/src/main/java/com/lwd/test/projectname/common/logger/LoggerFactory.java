package com.lwd.test.projectname.common.logger;


import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;

public class LoggerFactory {

    private static Map<String, Logger> loggerMap = new HashMap<String, Logger>();

    public static Logger getLogger(Class<? extends Logger> extLogger, String name) {
        Logger slf4jLogger = null;
        // protect against concurrent access of loggerMap
        synchronized (name) {
            slf4jLogger = (Logger) loggerMap.get(name);
            if (slf4jLogger == null) {
                org.apache.log4j.Logger log4jLogger;
                if (name.equalsIgnoreCase(Logger.ROOT_LOGGER_NAME)) {
                    log4jLogger = LogManager.getRootLogger();
                } else {
                    log4jLogger = LogManager.getLogger(name);
                }

                //有指定实例化logger类
                if (null != extLogger) {
                    try {
                        slf4jLogger =  extLogger.getConstructor(org.apache.log4j.Logger.class).newInstance(log4jLogger);
//                        slf4jLogger = (Logger) extLogger.newInstance();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        
                        slf4jLogger = null;
                    }
                }

                if (null == slf4jLogger) {
                    slf4jLogger = new Log4jLoggerAdapter(log4jLogger);
                }

                loggerMap.put(name, slf4jLogger);
            }
        }
        return slf4jLogger;
    }

    /**
     * Return a logger named according to the name parameter using the statically
     * bound {@link ILoggerFactory} instance.
     * @param name The name of the logger.
     * @return logger
     */
    public static Logger getLogger(String name) {
        Logger slf4jLogger = null;
        // protect against concurrent access of loggerMap
        synchronized (name) {
            slf4jLogger = (Logger) loggerMap.get(name);
            if (slf4jLogger == null) {
                org.apache.log4j.Logger log4jLogger;
                if (name.equalsIgnoreCase(Logger.ROOT_LOGGER_NAME)) {
                    log4jLogger = LogManager.getRootLogger();
                } else {
                    log4jLogger = LogManager.getLogger(name);
                }
                slf4jLogger = new Log4jLoggerAdapter(log4jLogger);
                loggerMap.put(name, slf4jLogger);
            }
        }
        return slf4jLogger;
    }

    /**
     * Return a logger named corresponding to the class passed as parameter, using
     * the statically bound {@link ILoggerFactory} instance.
     * @param clazz the returned logger will be named after clazz
     * @return logger
     */
    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

}
