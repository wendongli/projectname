/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.lwd.test.projectname.dal.dao;

import com.lwd.test.projectname.dal.pojo.CpUserPojo;

/**
 * CP用户Dao
 * 
 * @author wendong.lwd
 * 
 */
public interface CpUserDao {

    /**
     * 插入一条cp用户信息
     * 
     * @param pojo
     * @return
     */
    int add(CpUserPojo pojo);

    /**
     * 更新一条cp用户信息
     * 
     * @param pojo
     * @return
     */
    boolean update(CpUserPojo pojo);

    /**
     * 条件查询一条cp用户信息
     * 
     * @param condition
     * @return
     */
    CpUserPojo getByCondition(CpUserPojo condition);

}
