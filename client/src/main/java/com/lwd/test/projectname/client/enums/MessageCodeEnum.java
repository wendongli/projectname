package com.lwd.test.projectname.client.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误码
 * 
 * @author wendong.lwd
 * 
 */
public enum MessageCodeEnum {

    UNKNOWN("未知错误"),

    PARAMS_FAIL("参数有误"),

    OPERATION_SUCCESS("操作成功"),

    OPERATION_FAILED("操作失败"),

    ILLEGAL_REQUEST_PARAMETER("请求参数非法"),

    SYS_ERROR("很抱歉，服务异常，请稍后重试！"),

    TOO_MANY_REQUEST("亲，人多拥挤，勤加练习，继续努力哦！"),

    UUID_VERIFY_FAIL("设备不支持"),

    USER_NOT_LOGIN("亲，您还没登录，请先登录哦！"),

    REQUEST_TOO_QUICK("亲，您点太快了，请歇一会再试");

    private String message;

    private static Map<String, MessageCodeEnum> pool = new HashMap<String, MessageCodeEnum>();

    static {
        for (MessageCodeEnum each : MessageCodeEnum.values()) {
            pool.put(each.name(), each);
        }
    }

    private MessageCodeEnum(String message) {
        this.message = message;
    }

    public static MessageCodeEnum index(String name) {
        return pool.get(name);
    }

    public String getMessage() {
        return message;
    }

}
