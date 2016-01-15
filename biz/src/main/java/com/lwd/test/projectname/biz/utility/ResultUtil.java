/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.lwd.test.projectname.biz.utility;

import com.lwd.test.projectname.client.enums.MessageCodeEnum;
import com.taobao.mtop.common.Result;

/**
 * 封装Mtop的Result结构体
 * 
 */
public class ResultUtil {

    /**
     * 成功请求
     * 
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<T>();
    }

    /**
     * 成功请求,带自定义信息
     * 
     * @param messageCode
     * @return
     */
    public static <T> Result<T> success(MessageCodeEnum messageCode) {
        return new Result<T>(true, messageCode.name(), messageCode.getMessage());
    }

    /**
     * 成功请求,带数据
     * 
     * @param data
     * @return
     */
    public static <T> Result<T> success(T model) {
        return new Result<T>(model);
    }

    /**
     * 失败请求,带自定义错误信息
     * 
     * @param messageCode
     * @return
     */
    public static <T> Result<T> error(MessageCodeEnum messageCode) {
        return new Result<T>(false, messageCode.name(), messageCode.getMessage());
    }

    /**
     * 失败请求,带错误码及错误信息
     * 
     * @param msgCode
     * @param msgInfo
     * @return
     */
    public static <T> Result<T> error(String msgCode, String msgInfo) {
        return new Result<T>(false, msgCode, msgInfo);
    }
}
