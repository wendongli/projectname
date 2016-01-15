package com.lwd.test.projectname.common.logger;

import java.io.Serializable;

import org.apache.log4j.Level;

import com.lwd.test.projectname.common.util.LoggerUtil;

/**
 * A wrapper over {@link org.apache.log4j.Logger org.apache.log4j.Logger} in conforming to the {@link Logger} interface.
 * <p>
 * Note that the logging levels mentioned in this class refer to those defined in the <a
 * href="http://logging.apache.org/log4j/docs/api/org/apache/log4j/Level.html"> <code>org.apache.log4j.Level</code></a>
 * class.
 * <p>
 * The TRACE level was introduced in log4j version 1.2.12. In order to avoid crashing the host application, in the case
 * the log4j version in use predates 1.2.12, the TRACE level will be mapped as DEBUG. See also <a
 * href="http://bugzilla.slf4j.org/show_bug.cgi?id=68">bug 68</a>.
 * 
 * @author Ceki G&uuml;lc&uuml;
 */
public class Log4jLoggerAdapter implements Logger, Serializable {

    /**
     * 
     */
    private static final long               serialVersionUID = -3685614252049436832L;

    final transient org.apache.log4j.Logger logger;

    /**
     * Following the pattern discussed in pages 162 through 168 of "The complete log4j manual".
     */
    public final static String              FQCN             = Log4jLoggerAdapter.class.getName();

    // WARN: Log4jLoggerAdapter constructor should have only package access so
    // that
    // only Log4jLoggerFactory be able to create one.
    Log4jLoggerAdapter(org.apache.log4j.Logger logger){
        this.logger = logger;
    }

    @Override
    public void debug(Scope scope, String message) {
        if (logger.isEnabledFor(Level.DEBUG)) {
            logger.log(FQCN, Level.DEBUG, scope.scope + message, null);
        }
    }

    @Override
    public void debug(Scope scope, String pattern, Object... paras) {
        if (logger.isEnabledFor(Level.DEBUG)) {
            logger.log(FQCN, Level.DEBUG, scope.scope + LoggerUtil.format(pattern, paras), null);
        }
    }

    @Override
    public void info(String message) {
        if (logger.isEnabledFor(Level.INFO)) {
            logger.log(FQCN, Level.INFO, message, null);
        }
    }

    @Override
    public void info(Scope scope, String message) {
        if (logger.isEnabledFor(Level.INFO)) {
            logger.log(FQCN, Level.INFO, scope.scope + message, null);
        }
    }

    @Override
    public void info(Scope scope, String pattern, Object... paras) {
        if (logger.isEnabledFor(Level.INFO)) {
            logger.log(FQCN, Level.INFO, scope.scope + LoggerUtil.format(pattern, paras), null);
        }
    }

    @Override
    public void warn(Scope scope, String message) {
        if (logger.isEnabledFor(Level.WARN)) {
            logger.log(FQCN, Level.WARN, scope.scope + message, null);
        }
    }

    @Override
    public void warn(Scope scope, String pattern, Object... paras) {
        if (logger.isEnabledFor(Level.WARN)) {
            logger.log(FQCN, Level.WARN, scope.scope + LoggerUtil.format(pattern, paras), null);
        }
    }

    @Override
    public void warn(Scope scope, Throwable e, String pattern, Object... paras) {
        if (logger.isEnabledFor(Level.WARN)) {
            logger.log(FQCN, Level.WARN, scope.scope + LoggerUtil.format(pattern, paras), e);
        }
    }

    @Override
    public void warn(Scope scope, Throwable e, String message) {
        if (logger.isEnabledFor(Level.WARN)) {
            logger.log(FQCN, Level.WARN, scope.scope + message, e);
        }
    }

    @Override
    public void error(Scope scope, String message) {
        if (logger.isEnabledFor(Level.ERROR)) {
            logger.log(FQCN, Level.ERROR, scope.scope + message, null);
        }
    }

    @Override
    public void error(Scope scope, String pattern, Object... paras) {
        if (logger.isEnabledFor(Level.ERROR)) {
            logger.log(FQCN, Level.ERROR, scope.scope + LoggerUtil.format(pattern, paras), null);
        }
    }

    @Override
    public void error(Scope scope, Throwable e, String pattern, Object... paras) {
        if (logger.isEnabledFor(Level.ERROR)) {
            logger.log(FQCN, Level.ERROR, scope.scope + LoggerUtil.format(pattern, paras), e);
        }
    }

    @Override
    public void error(Scope scope, Throwable e, String message) {
        if (logger.isEnabledFor(Level.ERROR)) {
            logger.log(FQCN, Level.ERROR, scope.scope + message, e);
        }
    }

}
