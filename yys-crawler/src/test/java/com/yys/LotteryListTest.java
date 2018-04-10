package com.yys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yys.domain.LotteryList;
import com.yys.domain.User;
import com.yys.service.LotteryListService;
import com.yys.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LotteryListTest {

    @Autowired
    private LotteryListService<LotteryList>  service;

    @Test
    public void save(){
        LotteryList lotteryList = null;
        String key = "312da6567dc7453369ea030b9a749051";
        String URI ="http://apis.juhe.cn/lottery/types"+"?key="+key;
        String jsonData =  HttpClientUtils.getMethod(URI);
        JSONObject jsonObject = JSON.parseObject(jsonData);
        if (jsonObject.getIntValue("error_code")==0){
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            if (jsonArray!=null){
                for (int i = 0 ; i<jsonArray.size();i++){
                    JSONObject arrayObject = jsonArray.getJSONObject(i);
                    lotteryList = new LotteryList();
//               lotteryList.setId(1);
                    lotteryList.setLottery_Id(arrayObject.get("lottery_id").toString());
                    lotteryList.setLottery_Name(arrayObject.get("lottery_name").toString());
                    lotteryList.setLottery_Type_Id(arrayObject.get("lottery_type_id").toString());
                    lotteryList.setDatetime(new Date());
                    lotteryList.setRemarks(arrayObject.get("remarks").toString());
                    this.service.save(lotteryList);
                    lotteryList = null;
                }
                System.out.println("success!");
            }
        }else {
            System.out.println("获取接口数据有问题！"+jsonObject);
        }

    }
}
