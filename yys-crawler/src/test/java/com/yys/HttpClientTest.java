package com.yys;

import com.yys.utils.HttpClientUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Date;

public class HttpClientTest {
    public  static void main(String[] args){
        String appKey = "312da6567dc7453369ea030b9a749051";
        String uri ="http://apis.juhe.cn/lottery/query"+"?key="+appKey;
        uri += "&lottery_id=qxc&lottery_no=";
       String jsonData =  HttpClientUtils.postMethod(uri);
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
