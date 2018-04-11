package com.yys.repository;

import com.yys.domain.LotteryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LotteryResultDaoImpl extends BasicDaoImpl<LotteryResult> {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private BasicDao<LotteryResult>  basicDao;

    @Override
    public void insert(LotteryResult lotteryResult) {
//        mongoTemplate.insert(lotteryResult);
        basicDao.insert(lotteryResult);
    }

    public List<LotteryResult> findAll() {
//        return this.mongoTemplate.findAll(LotteryResult.class);
        return  this.basicDao.findAll(LotteryResult.class);
    }

     public List<LotteryResult>   findByObj(String key){
//         Query query = Criteria.where(key).is(key);
//        return basicDao.findByObj(query,LotteryResult.class);
         return null;
     }
}
