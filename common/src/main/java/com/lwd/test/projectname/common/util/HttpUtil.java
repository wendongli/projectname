package com.lwd.test.projectname.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.lang.StringUtils;

import com.lwd.test.projectname.common.logger.Logger;
import com.lwd.test.projectname.common.logger.Logger.HTTP;
import com.lwd.test.projectname.common.logger.LoggerFactory;

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 执行POST请求
     * 
     * @param url
     * @param timeout
     * @return
     */
    public static String doPost(String url, int timeout) {
        String response = StringUtils.EMPTY;

        HttpClient httpClient = new HttpClient();
        HttpConnectionManagerParams connectionManagerParams = httpClient.getHttpConnectionManager()
                .getParams();
        connectionManagerParams.setConnectionTimeout(timeout);// 连接超时时间(毫秒)
        connectionManagerParams.setSoTimeout(timeout);// 读取超时时间(毫秒)

        PostMethod method = new PostMethod(url);
        try {
            httpClient.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                InputStreamReader streamReader = new InputStreamReader(
                        method.getResponseBodyAsStream(), "utf-8");
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuffer strBuf = new StringBuffer();
                String strTmp = "";
                while ((strTmp = reader.readLine()) != null) {
                    strBuf.append(strTmp);
                }
                response = strBuf.toString();
            } else {
                logger.warn(HTTP.DEFAULT, "Post Failed!url=[{}], statusCode=[{}], statusMsg=[{}]",
                        url, method.getStatusCode(), method.getStatusText());
            }
        } catch (HttpException e) {
            logger.warn(HTTP.REQUEST_PROCESS_EXCEPTION, e, "Post Failed!url=[{}]", url);
        } catch (IOException e) {
            logger.warn(HTTP.REQUEST_PROCESS_EXCEPTION, e, "Post Failed!url=[{}]", url);
        }

        return response;
    }

}
