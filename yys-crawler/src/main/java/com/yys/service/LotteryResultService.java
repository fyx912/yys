package com.yys.service;

import com.yys.domain.LotteryResult;

import java.util.List;

public interface LotteryResultService {
     void insert(LotteryResult result);
     List<LotteryResult> findAll();
}
