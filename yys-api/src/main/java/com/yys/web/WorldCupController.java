package com.yys.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yys.utils.HttpClientUtils;
import domain.WorldCupChampionGuess;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldCupController {

    @RequestMapping(value = "wcgj",method = RequestMethod.GET)
    public String wcgj(){
        String wcgjUrl = "http://i.sporttery.cn/rank_calculator/get_rank_data?tid[]=104895&&pcode[]=chp&i_callback=getChpDetail";
        String wcgjData = HttpClientUtils.getMethod(wcgjUrl);
        System.out.println("世界杯冠军数据:"+wcgjData);
        String data = wcgjData.substring( wcgjData.indexOf("(")+1,wcgjData.lastIndexOf(")"));
        System.out.println("世界杯冠军数据:"+data);
        return data;
    }


    @RequestMapping(value = "wcgyj",method = RequestMethod.GET)
    public String wcgyj(){
        String wcgyjUrl = "http://i.sporttery.cn/rank_calculator/get_rank_data?tid[]=104895&&pcode[]=fnl&i_callback=getChange&_=1526372433248";
        String wcgyjData = HttpClientUtils.getMethod(wcgyjUrl);
        System.out.println("世界杯冠亚军数据:"+wcgyjData);
        String data = wcgyjData.substring( wcgyjData.indexOf("(")+1,wcgyjData.lastIndexOf(")"));
        System.out.println("世界杯冠军数据:"+data);
        return data;
    }

    @RequestMapping(value = "wcgjdata",method = RequestMethod.GET)
    public String wcgjData(){
        String wcgyjUrl = "http://i.sporttery.cn/rank_calculator/get_list?tid[]=104895&pcode[]=chp&i_callback=cphData&_=1526372433257";
        String wcgyjData = HttpClientUtils.getMethod(wcgyjUrl);
        System.out.println("世界杯冠军数据:"+wcgyjData);
        String data = wcgyjData.substring( wcgyjData.indexOf("(")+1,wcgyjData.lastIndexOf(")"));
        JSONObject jsonObject = JSONObject.parseObject(data);
        JSONArray jsonData = jsonObject.getJSONArray("data");
        String dataString = jsonData.getJSONObject(0).getString("data");
        System.out.println("世界杯冠军数据:"+dataString);
        String[] dataParse = dataString.split("\\|");
        for (int i = 0; i < dataParse.length; i++) {
            System.out.println("split array "+i+":\t"+dataParse[i]);
        }
        jsonObject.put("dataParse",dataParse);
        jsonObject.put("jsonData",parseData(dataParse));
        return jsonObject.toString();
    }

    @RequestMapping(value = "wcgyjdata",method = RequestMethod.GET)
    public String wcgyjdata(){
        String wcgyjUrl = "http://i.sporttery.cn/rank_calculator/get_list?tid[]=104895&&pcode[]=fnl&i_callback=getList&_=1526372433398";
        String wcgyjData = HttpClientUtils.getMethod(wcgyjUrl);
        String data = wcgyjData.substring( wcgyjData.indexOf("(")+1,wcgyjData.lastIndexOf(")"));
        JSONObject jsonObject = JSONObject.parseObject(data);
        JSONArray jsonData = jsonObject.getJSONArray("data");
        String dataString = jsonData.getJSONObject(0).getString("data");
        System.out.println("世界杯冠亚军数据:"+dataString);
        String[] dataParse = dataString.split("\\|");
        for (int i = 0; i < dataParse.length; i++) {
            System.out.println("split array "+i+":\t"+dataParse[i]);
        }
        jsonObject.put("dataParse",dataParse);
        return jsonObject.toString();
    }

    /**
     * 1-巴西-开售-2.95-0%-19.27%-4671301-equal-467130-1-417-http://static.sporttery.cn/sinaimg/football/wcp2018/417.png
     * 把string 转换为jsonObject
     * @param data
     * @return
     */
    public String parseData(String[] data){
        if (data.length > 0){
            JSONArray jsonArray = new JSONArray();
            WorldCupChampionGuess worldCup =null;
            for (int i = 0; i < data.length; i++) {
                worldCup = new WorldCupChampionGuess();
                String parseData = data[i];
                String[] dataValue = parseData.split("-");
                worldCup.setId(Integer.valueOf(dataValue[0]));
                worldCup.setBallTeam(dataValue[1]);
                if (dataValue[2].equals("开售")){
                    worldCup.setStatus(0);
                }else{
                    worldCup.setStatus(1);
                }
                worldCup.setBonus(Double.valueOf(dataValue[3]));
                worldCup.setProbability(dataValue[4]);
                worldCup.setImgUrl(dataValue[11]);
                jsonArray.add(JSONObject.toJSON(parseData));
            }
            return  jsonArray.toJSONString();
        }else {
            return null;
        }
    }
}
