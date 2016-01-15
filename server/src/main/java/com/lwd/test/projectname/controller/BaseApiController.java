package com.lwd.test.projectname.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.lwd.test.projectname.common.logger.Logger;
import com.lwd.test.projectname.common.logger.LoggerFactory;

public class BaseApiController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;

}
