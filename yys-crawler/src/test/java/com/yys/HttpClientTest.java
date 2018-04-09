package com.yys;

import com.yys.utils.HttpClientUtils;

public class HttpClientTest {
    public  static void main(String[] args){
        String URI ="http://apis.juhe.cn/lottery/types";
        HttpClientUtils.postMethod(URI);
        HttpClientUtils.getMethod(URI);
    }
}
