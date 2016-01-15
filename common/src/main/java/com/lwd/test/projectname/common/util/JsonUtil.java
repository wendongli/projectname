package com.lwd.test.projectname.common.util;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * json工具包类
 * 
 */
public class JsonUtil {

    private static Gson gson = new Gson();

    public static Object json2object(String json) {
        return gson.fromJson(json, Object.class);
    }

    public static <T> T json2object(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static boolean isJsonStr(String json) {
        if (StringUtils.isBlank(json)) {
            return false;
        }
        try {
            JsonParser jsonParser = new JsonParser();
            return jsonParser.parse(json).isJsonObject();
        } catch (JsonSyntaxException e) {
        }

        return false;
    }
}
