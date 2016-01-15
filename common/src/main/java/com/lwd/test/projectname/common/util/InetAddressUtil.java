package com.lwd.test.projectname.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.alibaba.alimonitor.jmonitor.utils.StringUtils;


public class InetAddressUtil {

	private static String	host = StringUtils.EMPTY;
	private static String	ip = StringUtils.EMPTY;

	static {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			host = ia.getHostName();//获取计算机主机名  
			ip = ia.getHostAddress();//获取计算机IP  
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static String getHostName() {
		return host;
	}
	
	public static String getIp() {
		return ip;
	}
}
