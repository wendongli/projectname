/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.lwd.test.projectname.biz.utility;

import org.apache.commons.lang.StringUtils;

/**
 * 图片地址组手，用于获取图片完整路径 date: 2014-10-23 下午3:38:09 <br/>
 * 
 */
public class ImageUtil {

    public String getImageRealPath(String imagePath) {
        if (StringUtils.isEmpty(imagePath) || imagePath.startsWith("http://")
                || imagePath.startsWith("https://")) {
            return imagePath;
        }
        return ConfigUtil.getCdnHost() + imagePath;
    }
}
