/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.lwd.test.projectname.dal.pojo;

import com.lwd.test.projectname.common.AbstractEntity;

/**
 * CP用户POJO
 * 
 * @author wendong.lwd
 * 
 */
public class CpUserPojo extends AbstractEntity {

    private static final long serialVersionUID = 5682603271442671689L;

    /** 主键ID */
    private Long id;

    /** 用户类型 */
    private Integer license;

    /** 用户的CA卡号 */
    private String cardNo;

    /** 分配给用户的淘宝uid */
    private Long uid;

    public CpUserPojo() {
    }

    public CpUserPojo(Integer license, String cardNo) {
        this.license = license;
        this.cardNo = cardNo;
    }

    public CpUserPojo(Integer license, String cardNo, Long uid) {
        this.license = license;
        this.cardNo = cardNo;
        this.uid = uid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLicense() {
        return license;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
