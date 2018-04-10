package com.yys.service;

import com.yys.domain.LotteryList;

import java.util.List;

public interface LotteryListService<T> {
    LotteryList save(LotteryList lotteryList);
    List<T> findAll();
}
