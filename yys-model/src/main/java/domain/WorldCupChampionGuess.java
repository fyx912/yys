package domain;


import lombok.Data;

import java.util.Date;

/**
 * 世界杯冠军猜想
 * @author yaqiangding
 * @version 1.0
 * @create 2018-5-14
 */
@Data
public class WorldCupChampionGuess {
    private Integer id;
    private Integer wId;//编号
    private String ballTeam;//球队
    private Integer status;//状态:0开售,1停售
    private Double bonus;//奖金
    private String probability;//概率需要追加%
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String imgUrl;//图片路径

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public String getBallTeam() {
        return ballTeam;
    }

    public void setBallTeam(String ballTeam) {
        this.ballTeam = ballTeam;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
