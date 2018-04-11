package com.yys.domain;

import javax.persistence.*;

/**
 * 彩票开奖-超级大乐透
 */
@Entity
@Table(name = "t_lottery_result_dlt")
public class LotteryResultDlt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lottery_no")
    private String lottery_no;      //'开奖期号',

    @Column(name = "lottery_red")
    private String lottery_red;     //'开奖结果-红球',

    @Column(name = "lottery_blue")
    private String lottery_blue;    //'开奖结果-篮球',

    @Column(name = "lottery_date")
    private String lottery_date;    //'开奖日期'

    @Column(name = "lottery_exdate")
    private String lottery_exdate;  //'兑奖截止日期',

    @Column(name = "lottery_sale_amount")
    private String lottery_sale_amount; //'本期销售额(投注总额)',

    @Column(name = "lottery_pool_amount")
    private String lottery_pool_amount;   //'奖池滚存',

    public LotteryResultDlt() {
    }

    public LotteryResultDlt(String lottery_no, String lottery_red, String lottery_blue, String lottery_date, String lottery_exdate, String lottery_sale_amount, String lottery_pool_amount) {
        this.lottery_no = lottery_no;
        this.lottery_red = lottery_red;
        this.lottery_blue = lottery_blue;
        this.lottery_date = lottery_date;
        this.lottery_exdate = lottery_exdate;
        this.lottery_sale_amount = lottery_sale_amount;
        this.lottery_pool_amount = lottery_pool_amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLottery_no() {
        return lottery_no;
    }

    public void setLottery_no(String lottery_no) {
        this.lottery_no = lottery_no;
    }

    public String getLottery_red() {
        return lottery_red;
    }

    public void setLottery_red(String lottery_red) {
        this.lottery_red = lottery_red;
    }

    public String getLottery_blue() {
        return lottery_blue;
    }

    public void setLottery_blue(String lottery_blue) {
        this.lottery_blue = lottery_blue;
    }

    public String getLottery_date() {
        return lottery_date;
    }

    public void setLottery_date(String lottery_date) {
        this.lottery_date = lottery_date;
    }

    public String getLottery_exdate() {
        return lottery_exdate;
    }

    public void setLottery_exdate(String lottery_exdate) {
        this.lottery_exdate = lottery_exdate;
    }

    public String getLottery_sale_amount() {
        return lottery_sale_amount;
    }

    public void setLottery_sale_amount(String lottery_sale_amount) {
        this.lottery_sale_amount = lottery_sale_amount;
    }

    public String getLottery_pool_amount() {
        return lottery_pool_amount;
    }

    public void setLottery_pool_amount(String lottery_pool_amount) {
        this.lottery_pool_amount = lottery_pool_amount;
    }
}
