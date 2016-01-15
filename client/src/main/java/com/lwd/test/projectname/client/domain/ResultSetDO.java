package com.lwd.test.projectname.client.domain;

import com.lwd.test.projectname.client.common.AbstractEntity;
import com.lwd.test.projectname.client.enums.MessageCodeEnum;

/**
 * service层返回结果
 * 
 * @param <T>
 */
public class ResultSetDO<T> extends AbstractEntity {

    private static final long serialVersionUID = 4623285865195854487L;

    /** 是否正常取到值 */
    private boolean success;

    /** 提示信息code */
    private MessageCodeEnum code;

    /** 错误信息 */
    private String message;

    /** 传递参数 */
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MessageCodeEnum getCode() {
        return code;
    }

    public void setCode(MessageCodeEnum code) {
        this.code = code;
    }

    public ResultSetDO(boolean success, MessageCodeEnum code) {
        this.success = success;
        this.code = code;
        this.message = code.getMessage();
    }

    public ResultSetDO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultSetDO() {
        this.success = true;
    }

    public ResultSetDO(T data) {
        this.success = true;
        this.data = data;
    }

    public String getMessage() {
        if (message != null) {
            return message;
        }
        if (code != null) {
            return code.getMessage();
        }
        return null;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
