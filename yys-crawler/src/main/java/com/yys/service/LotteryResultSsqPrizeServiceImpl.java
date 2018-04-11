package com.yys.service;

import com.yys.domain.LotteryResultSsqPrize;
import com.yys.repository.LotteryResultSsqPrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotteryResultSsqPrizeServiceImpl implements LotteryResultSsqPrizeService {

    @Autowired
    private LotteryResultSsqPrizeRepository ssqPrizeRepository;

    @Override
    public LotteryResultSsqPrize save(LotteryResultSsqPrize resultSsqPrize) {
        return this.ssqPrizeRepository.save(resultSsqPrize);
    }
}
