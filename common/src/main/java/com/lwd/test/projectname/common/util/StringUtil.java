package com.lwd.test.projectname.common.util;

import java.util.List;
import java.util.Random;

public class StringUtil {

    /**
     * 格式化数据堆栈
     * 
     * @param listId 数据堆栈
     * @param split 数据分隔符
     * @return 用数据分隔符隔开的数据字符串
     */
    public static String join(List<String> listStr, String split) {
        if (listStr == null || listStr.isEmpty()) {
            return "";
        }

        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < listStr.size() - 1; i++) {
            buf.append(listStr.get(i)).append(split);
        }
        buf.append(listStr.get(listStr.size() - 1));

        return buf.toString();
    }

    /**
     * 用分隔符连接的字符串
     * 
     * @param arr 字符串队列
     * @param separator 分隔符
     * @return 返回用分隔符连接的字符串
     */
    public static String join(String[] listStr, String split) {
        if (listStr == null || listStr.length == 0) {
            return "";
        }

        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < listStr.length - 1; i++) {
            buf.append(listStr[i]).append(split);
        }
        buf.append(listStr[listStr.length - 1]);

        return buf.toString();
    }

    /**
     * 随机生成固定长度的字符串
     * 
     * @param length
     * @return String
     */
    public static String getRandomString(int length) { // length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 判断字符串数组中是否包含某字符串
     * 
     * @param source
     * @param needle
     * @return
     */
    public static Boolean isHave(String right, String needle) {
        if (right == null || needle == null) return false;
        String[] source = right.split(";");
        for (String s : source) {
            if (s.equals(needle)) return true;
        }
        return false;
    }

    /**
     * 生成以5开头的随机16位数字串，用于pk
     * 
     * @return
     */
    public static String uuid() {
        String timeStamp = String.valueOf(System.currentTimeMillis());
        return "5" + randomNumString(4) + timeStamp.substring(2);
    }

    /**
     * 生成纯数字的随机数
     * 
     * @param length
     * @return
     */
    public static final String randomNumString(int length) {
        Random random = new Random(System.nanoTime());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(10);
            sb.append(number);
        }
        return sb.toString();
    }

    /**
     * 检查字符串是否为<code>null</code>或空字符串<code>""</code>。
     * 
     * <pre>
     * StringUtil.isEmpty(null) = true
     * StringUtil.isEmpty("") = true
     * StringUtil.isEmpty(" ") = false
     * StringUtil.isEmpty("bob") = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     * 
     * @param str 要检查的字符串
     * @return 如果为空, 则返回<code>true</code>
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    /**
     * 按pattern模板替换paras参数
     * 
     * @param pattern
     * @param paras
     * @return
     */
    public static String format(String pattern, Object... paras) {
        if (null == pattern && null == paras) {
            return pattern;
        }
        if (null == pattern) {
            StringBuffer buf = new StringBuffer();
            for (Object obj : paras) {
                buf.append(obj);
            }
            return buf.toString();
        }
        int count = 0;
        while (pattern.contains("{}")) {
            if (paras.length <= count) {
                break;
            }
            pattern = pattern.replaceFirst("\\{\\}", paras[count++].toString());
        }
        return pattern;
    }
}
