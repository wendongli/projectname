package com.lwd.test.projectname.common.util;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.google.gson.Gson;

/**
 * 日志工具包类
 */
public class LoggerUtil {

    private final static String NULL = "NULL";

    private static Gson gson = new Gson();

    private final static String REQUEST_OUT_PATTERN = "HttpServletRequest=[uri[{0}],parameterMap[{1}]]";

    public static String out(HttpServletRequest request) {
        if (null == request) {
            return NULL;
        }

        try {
            return MessageFormat.format(REQUEST_OUT_PATTERN, request.getRequestURI(),
                    json(request.getParameterMap()));
        } catch (Exception e) {
            e.printStackTrace();

            return NULL;
        }
    }

    /**
     * obj out with {@link ToStringStyle#SHORT_PREFIX_STYLE}
     * 
     * @param obj
     * @return
     */
    public static String out(Object obj) {
        return ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * obj out json串
     * 
     * @param obj
     * @return
     * @see Gson#toJson(Object)
     */
    public static String json(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * 按pattern模板替换paras参数
     * 
     * @param pattern
     * @param paras
     * @return
     */
    public static String format(String pattern, Object... paras) {
        int count = 0;
        while (pattern.contains("[{}]")) {
            pattern = pattern.replaceFirst("\\[\\{\\}\\]", "[{" + (count++) + "}]");
        }
        return MessageFormat.format(pattern, paras);
    }

}
