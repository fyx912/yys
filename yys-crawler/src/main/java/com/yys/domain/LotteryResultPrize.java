package com.yys.domain;

import javax.persistence.Column;

public class LotteryResultPrize {

//    @Column(name = "prize_name")
    private String prize_name;   //奖项名称

//    @Column(name = "prize_num")
    private String prize_num;   //中奖数量

//    @Column(name = "prize_amount")
    private String prize_amount;    //中奖金额


    private String prize_require;   //中奖条件


    public LotteryResultPrize() {
    }

    public LotteryResultPrize(String prize_name, String prize_num, String prize_amount, String prize_require) {
        this.prize_name = prize_name;
        this.prize_num = prize_num;
        this.prize_amount = prize_amount;
        this.prize_require = prize_require;
    }

    public String getPrize_name() {
        return prize_name;
    }

    public void setPrize_name(String prize_name) {
        this.prize_name = prize_name;
    }

    public String getPrize_num() {
        return prize_num;
    }

    public void setPrize_num(String prize_num) {
        this.prize_num = prize_num;
    }

    public String getPrize_amount() {
        return prize_amount;
    }

    public void setPrize_amount(String prize_amount) {
        this.prize_amount = prize_amount;
    }

    public String getPrize_require() {
        return prize_require;
    }

    public void setPrize_require(String prize_require) {
        this.prize_require = prize_require;
    }
}
