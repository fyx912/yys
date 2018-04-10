package com.yys.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_lottery_list")
public class LotteryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "lottery_id")
    private String lottery_Id;
    @Column(name = "lottery_type_id")
    private String lottery_Type_Id;
    @Column(name = "lottery_name")
    private String lottery_Name;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;

    public LotteryList() {
    }

    public LotteryList(String lottery_Id, String lottery_Type_Id, String lottery_Name, String remarks, Date datetime) {
        this.lottery_Id = lottery_Id;
        this.lottery_Type_Id = lottery_Type_Id;
        this.lottery_Name = lottery_Name;
        this.remarks = remarks;
        this.datetime = datetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLottery_Id() {
        return lottery_Id;
    }

    public void setLottery_Id(String lottery_Id) {
        this.lottery_Id = lottery_Id;
    }

    public String getLottery_Type_Id() {
        return lottery_Type_Id;
    }

    public void setLottery_Type_Id(String lottery_Type_Id) {
        this.lottery_Type_Id = lottery_Type_Id;
    }

    public String getLottery_Name() {
        return lottery_Name;
    }

    public void setLottery_Name(String lottery_Name) {
        this.lottery_Name = lottery_Name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
