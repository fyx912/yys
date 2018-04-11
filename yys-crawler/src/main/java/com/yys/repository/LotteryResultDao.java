package com.yys.repository;

import com.yys.domain.LotteryResult;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LotteryResultDao extends BasicDao<LotteryResult> {
     void insert(LotteryResult result);
     List<LotteryResult > findAll();
}
