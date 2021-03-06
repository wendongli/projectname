package com.lwd.test.projectname.client.common;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 业务结构体
 * 
 */
public abstract class AbstractEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2435005092235830068L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
