package com.lwd.test.projectname.biz.utility;


import org.springframework.context.support.ApplicationObjectSupport;

public class ApplicationUtil extends ApplicationObjectSupport {

	public Object getBean(Class<?> clazz) {
		return getApplicationContext().getBean(clazz);
	}
}
