package com.yys.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class HttpClientUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
    /**
     * Http request get method
     * @param uri example "https://www.baidu.com/"
     * @return
     */
    public static String getMethod(String uri){
        String result = null;
        CloseableHttpClient httpClient=HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            System.out.println("executing request:" + httpGet.getURI());
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int code = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 打印响应内容
                result = EntityUtils.toString(entity);
            }
            logger.info(" GET {}, Response --->状态码:{},Content-Type:{},result:{}", httpGet.getURI(),code,entity.getContentType(),result);
        }catch (Exception e){
            logger.error("GET failure :caused by-->" + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Http request Post method
     * @param uri example "https://www.baidu.com/"
     * @return
     */
    public static String postMethod(String uri){
        String result = null;
        CloseableHttpClient httpClient=HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(uri);
            System.out.println("executing request:" + httpPost.getURI());
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int code = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 打印响应内容
                result = EntityUtils.toString(entity);
            }
            logger.info(" POST [{}], Response --->状态码:{},Content-Type:{},result:{}", httpPost.getURI(),code,entity.getContentType(),result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("POST failure :caused by-->" + e.getMessage());
        }finally {
            if (httpClient!=null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
