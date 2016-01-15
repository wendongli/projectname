package com.lwd.test.projectname.dal.dao;

import com.lwd.test.projectname.dal.pojo.CpUserPojo;

/**
 * CP用户Dao
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
