package com.lwd.test.projectname.biz.service;

import com.lwd.test.projectname.dal.pojo.CpUserPojo;

public interface CpUsreService {

    CpUserPojo get(int license, String uuid);
}
