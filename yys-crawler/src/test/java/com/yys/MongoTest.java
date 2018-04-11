package com.yys;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yys.domain.LotteryResult;
import com.yys.domain.LotteryResultPrize;
import com.yys.domain.LotteryResultSsqPrize;
import com.yys.service.LotteryResultService;
import com.yys.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    private LotteryResultService resultService;


    @Test
    public void save(){
        LotteryResult lotteryResult = null;
        LotteryResultPrize lotteryResultPrize = null;
        String key = "312da6567dc7453369ea030b9a749051";
        String uri ="http://apis.juhe.cn/lottery/query"+"?key="+key;
        uri += "&lottery_id=dlt&lottery_no=";
        String jsonData =  HttpClientUtils.getMethod(uri);
        JSONObject jsonObject = JSON.parseObject(jsonData);
        if (jsonObject.getIntValue("error_code")==0){
            JSONObject  resultJson = jsonObject.getJSONObject("result");
            String lottery_No = resultJson.getString("lottery_no");
            lotteryResult = new LotteryResult();
            lotteryResult.setLottery_no(lottery_No);
            String ssqBall_No = resultJson.getString("lottery_res");
            lotteryResult.setLottery_red(ssqBall_No.substring(0,ssqBall_No.lastIndexOf(",")));
            lotteryResult.setLottery_blue(ssqBall_No.substring(ssqBall_No.lastIndexOf(",")+1,ssqBall_No.length()));
            lotteryResult.setLottery_date(resultJson.getString("lottery_date"));
            lotteryResult.setLottery_exdate(resultJson.getString("lottery_exdate"));
            lotteryResult.setLottery_sale_amount(resultJson.getString("lottery_sale_amount"));
            lotteryResult.setLottery_pool_amount(resultJson.getString("lottery_sale_amount"));
            JSONArray jsonArray = resultJson.getJSONArray("lottery_prize");
            if (jsonArray!=null){
                List<LotteryResultPrize> list = new ArrayList<>();
                for (int i = 0 ; i<jsonArray.size();i++){
                    JSONObject arrayObject = jsonArray.getJSONObject(i);
                    lotteryResultPrize = new LotteryResultPrize();
                    lotteryResultPrize.setPrize_name(arrayObject.getString("prize_name"));
                    lotteryResultPrize.setPrize_num(arrayObject.getString("prize_num"));
                    lotteryResultPrize.setPrize_amount(arrayObject.getString("prize_amount"));
                    lotteryResultPrize.setPrize_require(arrayObject.getString("prize_require"));

                    list.add(lotteryResultPrize);
                }
                lotteryResult.setLottery_prize(list);
                System.out.println(lotteryResult.getLottery_no());
                this.resultService.insert(lotteryResult);
            }

            System.out.println("success!");

        }else {
            System.out.println("获取接口数据有问题！"+jsonObject);
        }

    }


    @Test
    public void findAll(){
        List<LotteryResult>  resultList =this.resultService.findAll();
        String result = JSON.toJSON(resultList).toString();
        System.out.println(result);
    }

    public static void main(String[] args){
        String data = "03,08,11,14,18,23,16";
        String red = data.substring(0,data.lastIndexOf(","));
        System.out.println(data+"\t"+red+"\t"+data.substring(data.lastIndexOf(",")+1,data.length()));
    }
}
