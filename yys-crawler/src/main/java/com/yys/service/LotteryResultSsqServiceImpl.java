package com.yys.service;

import com.yys.domain.LotteryResultSsq;
import com.yys.repository.LotteryResultSsqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotteryResultSsqServiceImpl implements LotteryResultSsqService{

    @Autowired
    LotteryResultSsqRepository  resultSsqRepository;

    @Override
    public LotteryResultSsq save(LotteryResultSsq resultSsq) {
        return  this.resultSsqRepository.save(resultSsq);
    }

}
