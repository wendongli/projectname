package com.lwd.test.projectname.common.logger;

import java.util.HashMap;
import java.util.Map;

/**
 * logger日志输出筛选类
 */
public class LoggerFilter {

    private static Map<Class<?>, Logger> loggerFilter = new HashMap<Class<?>, Logger>();

    static {
        Class<?>[] clazzes = Logger.class.getDeclaredClasses();
        for (Class<?> clazz : clazzes) {
            if (Logger.Scope.class.isAssignableFrom(clazz)) {
                loggerFilter.put(clazz, LoggerFactory.getLogger(clazz));
            }
        }
    }

    private static boolean isDAL(String className) {
        if (className.contains("org.mybatis.spring")) {
            return true;
        }
        if (className.contains("org.springframework.jdbc")) {
            return true;
        }
        if (className.contains("com.yunos.account.dal")) {
            return true;
        }
        return false;
    }

    private static boolean isBIZ(String className) {
        if (className.contains("com.yunos.account.biz")) {
            return true;
        }
        return false;
    }

    private static boolean isHTTP(String className) {
        if (className.contains("com.yunos.account.controller")) {
            return true;
        }
        if (className.contains("com.yunos.account.interceptor")) {
            return true;
        }
        if (className.contains("com.yunos.account.servlet")) {
            return true;
        }
        return false;
    }

    /**
     * 根据抛出的例外类判断属于DAL，BIZ，HTTP等等具体那层错误，用于日志分类输出
     * 
     * @param e
     * @return
     */
    public static Logger filter(Throwable e) {
        StackTraceElement[] traces = e.getStackTrace();
        boolean isDAL = false;
        boolean isBIZ = false;
        boolean isHTTP = false;
        for (StackTraceElement trace : traces) {
            if (!isDAL && isDAL(trace.getClassName())) {
                isDAL = true;
            }
            if (!isBIZ && isBIZ(trace.getClassName())) {
                isBIZ = true;
            }
            if (!isHTTP && isHTTP(trace.getClassName())) {
                isHTTP = true;
            }
        }

        if (isDAL) {
            return loggerFilter.get(Logger.DAL.class);
        }

        if (isBIZ) {
            return loggerFilter.get(Logger.BIZ.class);
        }

        if (isHTTP) {
            return loggerFilter.get(Logger.HTTP.class);
        }

        return loggerFilter.get(Logger.Scope.class);
    }

}
