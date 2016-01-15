package com.lwd.test.projectname.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.lwd.test.projectname.biz.service.CpUsreService;
import com.lwd.test.projectname.dal.dao.CpUserDao;
import com.lwd.test.projectname.dal.pojo.CpUserPojo;

public class CpUserServiceImpl extends AbstractBaseServiceImpl implements CpUsreService {

    @Autowired
    private CpUserDao cpUserDao;

    @Override
    public CpUserPojo get(int license, String uuid) {
        CpUserPojo condition = new CpUserPojo();
        condition.setLicense(license);
        condition.setCardNo(uuid);
        return cpUserDao.getByCondition(condition);
    }

}
