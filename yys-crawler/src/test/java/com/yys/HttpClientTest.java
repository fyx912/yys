package com.yys;

import com.yys.utils.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Date;

public class HttpClientTest {
    public  static void main(String[] args){
        String URI ="http://apis.juhe.cn/lottery/types";
       String jsonData =  HttpClientUtils.postMethod(URI);
       System.out.println(jsonData);
//        HttpClientUtils.getMethod(URI);
//        Long startTime = System.currentTimeMillis();
//        String lottery = "http://www.lottery.gov.cn/";
//        HttpClientUtils.getMethod(lottery);
//        Document document = Jsoup.parse(lottery);
//        System.out.println(document);
//        long  totalTime= System.currentTimeMillis()-startTime;
//        System.out.println(totalTime);
    }
}
