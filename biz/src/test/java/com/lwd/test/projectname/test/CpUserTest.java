package com.lwd.test.projectname.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.lwd.test.projectname.biz.service.CpUsreService;

public class CpUserTest extends BaseServiceTest {

    @Autowired
    private CpUsreService cpuserService;

    @Test
    public void test() {
        int license = 4;
        String uuid = "1234567";
        System.out.println(JSON.toJSONString(cpuserService.get(license, uuid)));
    }
}
