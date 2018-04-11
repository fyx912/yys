package com.yys.service;

import com.yys.domain.LotteryResult;
import com.yys.repository.BaseicDao;
import com.yys.repository.LotteryResultDao;
import com.yys.repository.LotteryResultDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryResultServiceImpl implements LotteryResultService {
    @Autowired
    private LotteryResultDaoImpl resultDao;
    @Override
    public void insert(LotteryResult result) {
         resultDao.insert(result);
    }

    @Override
    public List<LotteryResult> findAll() {
        return resultDao.findAll();
    }
}
