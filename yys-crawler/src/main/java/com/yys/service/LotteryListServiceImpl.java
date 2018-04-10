package com.yys.service;

import com.yys.domain.LotteryList;
import com.yys.repository.LotteryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryListServiceImpl implements LotteryListService<LotteryList>{

    @Autowired
    private LotteryListRepository listRepository;

    @Override
    public LotteryList save(LotteryList lotteryList) {
        return this.listRepository.save(lotteryList);
    }

    @Override
    public List<LotteryList> findAll() {
        return this.listRepository.findAll();
    }
}
