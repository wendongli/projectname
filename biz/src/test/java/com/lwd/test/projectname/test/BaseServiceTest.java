package com.lwd.test.projectname.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.taobao.hsf.standalone.HSFEasyStarter;

@ContextConfiguration(locations = { "classpath:spring-resource.xml", "classpath:spring-dal.xml",
        "classpath:hsf-consumer.xml", "classpath:spring-biz.xml" })
public class BaseServiceTest extends AbstractJUnit4SpringContextTests {

    static {
    	HSFEasyStarter.start("c:/temp", "2.1.0.4.7");
    }
}