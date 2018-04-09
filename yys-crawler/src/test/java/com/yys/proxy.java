package com.yys;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class proxy {
    public static void main(String[] args) {
        String result = null;
        String key = "312da6567dc7453369ea030b9a749051";
        HttpHost proxy = new HttpHost("127.0.0.1", 8080, "http"); //添加代理，IP为本地IP 8888就是fillder的端口
        CloseableHttpClient httpClient = HttpClients.createDefault();//添加代理
        try {
            //代理
            RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
            // 创建httpGet
//            HttpGet httpGet = new HttpGet("http://apis.juhe.cn/lottery/types");
//            httpGet.setHeader("Connection", "keep-alive");
//            httpGet.setConfig(config);
            HttpPost httpPost = new HttpPost("http://apis.juhe.cn/lottery/types"+"?key="+key);
            httpPost.setConfig(config);
            httpPost.setHeader("Connection", "keep-alive");
//            httpGet.addHeader(new BasicHeader("Cookie", cookies));

            System.out.println("executing request:" + httpPost.getURI());
            // 执行get请求
            CloseableHttpResponse response = httpClient.execute(httpPost);
                int code = response.getStatusLine().getStatusCode();
                System.out.println("返回的状态码:" + code);
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length" + entity.getContentLength());
                    // 打印响应内容
                    result = EntityUtils.toString(entity);
                    System.out.println("result\t:\t"+result);
                    // 打印响应头
                    System.out.println("Response content" + entity.getContent());
                    System.out.println("Response Contentype" + entity.getContentType());
                    System.out.println("Response ContenEncoding" + entity.getContentEncoding());
                }
                System.out.println("--------------");
                Header[] hr = response.getAllHeaders();
                for (int i = 0; i < hr.length; i++) {
                    Header header1 = hr[i];
                    System.out.println("头部内容：" + header1);
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           if (httpClient!=null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
           }
        }

    }
}
