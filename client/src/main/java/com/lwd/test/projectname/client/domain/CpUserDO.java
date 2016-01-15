package com.lwd.test.projectname.client.domain;

import com.lwd.test.projectname.client.common.AbstractEntity;

/**
 * 广电CP用户DO
 * 
 * @author wendong.lwd
 * 
 */
public class CpUserDO extends AbstractEntity {

    private static final long serialVersionUID = 1108277585940144621L;

    /**
     * 牌照方
     */
    private int license;

    /**
     * 用户的CA卡号
     */
    private String cardNo;

    /**
     * 分配给用户的淘宝id
     */
    private long uid = 0;

    public CpUserDO() {
    }

    public CpUserDO(int license, String cardNo, long uid) {
        this.license = license;
        this.cardNo = cardNo;
        this.uid = uid;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

}
