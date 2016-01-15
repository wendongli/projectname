package com.lwd.test.projectname.common.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * MD5工具类
 */
public class Md5Util {

    /**
     * 字符串MD5加密后返回字符串格式，32位
     * 
     * @param md5Str
     * @return
     */
    public static String MD5(String md5Str) {
        return new Md5PasswordEncoder().encodePassword(md5Str, StringUtils.EMPTY);
    }

    /**
     * 字符串MD5加密后返回字符串格式, 16位
     * 
     * @param md5Str
     * @param bit
     * @return
     */
    public static String MD5_16(String md5Str) {
        String md5 = new Md5PasswordEncoder().encodePassword(md5Str, StringUtils.EMPTY);
        return StringUtils.substring(md5, 8, 24);
    }
}
