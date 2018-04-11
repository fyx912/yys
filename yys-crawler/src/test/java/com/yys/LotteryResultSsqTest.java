package com.yys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yys.domain.LotteryResultSsq;
import com.yys.domain.LotteryResultSsqPrize;
import com.yys.service.LotteryResultSsqPrizeService;
import com.yys.service.LotteryResultSsqService;
import com.yys.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LotteryResultSsqTest {

    @Autowired
    private LotteryResultSsqService resultSsqService;
    @Autowired
    private LotteryResultSsqPrizeService lotteryResultSsqPrizeService;


    @Test
    public void save(){
        LotteryResultSsq resultSsq = null;
        LotteryResultSsqPrize lotteryResultSsqPrize = null;
        String key = "312da6567dc7453369ea030b9a749051";
        String uri ="http://apis.juhe.cn/lottery/query"+"?key="+key;
        uri += "&lottery_id=dlt&lottery_no=";
        String jsonData =  HttpClientUtils.getMethod(uri);
        JSONObject jsonObject = JSON.parseObject(jsonData);
        if (jsonObject.getIntValue("error_code")==0){
            JSONObject  resultJson = jsonObject.getJSONObject("result");
            String lottery_No = resultJson.getString("lottery_no");
            resultSsq = new LotteryResultSsq();
            resultSsq.setLottery_no(lottery_No);
            String ssqBall_No = resultJson.getString("lottery_res");
            resultSsq.setLottery_red(ssqBall_No.substring(0,ssqBall_No.lastIndexOf(",")));
            resultSsq.setLottery_blue(ssqBall_No.substring(ssqBall_No.lastIndexOf(",")+1,ssqBall_No.length()));
            resultSsq.setLottery_date(resultJson.getString("lottery_date"));
            resultSsq.setLottery_exdate(resultJson.getString("lottery_exdate"));
            resultSsq.setLottery_sale_amount(resultJson.getString("lottery_sale_amount"));
            resultSsq.setLottery_pool_amount(resultJson.getString("lottery_sale_amount"));
            this.resultSsqService.save(resultSsq);
            resultSsq = null;
            JSONArray jsonArray = resultJson.getJSONArray("lottery_prize");
            if (jsonArray!=null){
                for (int i = 0 ; i<jsonArray.size();i++){
                    JSONObject arrayObject = jsonArray.getJSONObject(i);
                    lotteryResultSsqPrize = new LotteryResultSsqPrize();
                    lotteryResultSsqPrize.setLottery_no(lottery_No);
                    lotteryResultSsqPrize.setPrize_name(arrayObject.getString("prize_name"));
                    lotteryResultSsqPrize.setPrize_num(arrayObject.getString("prize_num"));
                    lotteryResultSsqPrize.setPrize_amount(arrayObject.getString("prize_amount"));
                    lotteryResultSsqPrize.setPrize_require(arrayObject.getString("prize_require"));
                    this.lotteryResultSsqPrizeService.save(lotteryResultSsqPrize);
                    lotteryResultSsqPrize = null;
                }
                System.out.println("success!");
            }

        }else {
            System.out.println("获取接口数据有问题！"+jsonObject);
        }

    }


}
