package io.github.tawn0000.curation.entity;

import java.sql.Timestamp;

public class UE {
    //自增编号
    private Long ueId;
    //用户编号
    private Long uId;
    //展览编号
    private Long eId;
    //状态（0未报名，1已报名，2正在参加，3已参加
    private Integer ueStatus;
    //是否收藏
    private Integer ueCollection;
    //最后一次浏览时间
    private Timestamp ueTime;
    //最低心率
    private Integer ueHeartRateMin;
    //最高心率
    private Integer ueHeartRateMax;
    //平均心率
    private Integer ueHeartRateAve;
    //超出正常心率的次数
    private Integer ueHeartTimes;

    public UE(Long ueId, Long uId, Long eId, Integer ueStatus, Integer ueCollection, Timestamp ueTime, Integer ueHeartRateMin, Integer ueHeartRateMax, Integer ueHeartRateAve, Integer ueHeartTimes) {
        this.ueId = ueId;
        this.uId = uId;
        this.eId = eId;
        this.ueStatus = ueStatus;
        this.ueCollection = ueCollection;
        this.ueTime = ueTime;
        this.ueHeartRateMin = ueHeartRateMin;
        this.ueHeartRateMax = ueHeartRateMax;
        this.ueHeartRateAve = ueHeartRateAve;
        this.ueHeartTimes = ueHeartTimes;
    }

    public UE(Long uId, Long eId, Integer ueStatus, Integer ueCollection, Timestamp ueTime, Integer ueHeartRateMin, Integer ueHeartRateMax, Integer ueHeartRateAve, Integer ueHeartTimes) {
        this.uId = uId;
        this.eId = eId;
        this.ueStatus = ueStatus;
        this.ueCollection = ueCollection;
        this.ueTime = ueTime;
        this.ueHeartRateMin = ueHeartRateMin;
        this.ueHeartRateMax = ueHeartRateMax;
        this.ueHeartRateAve = ueHeartRateAve;
        this.ueHeartTimes = ueHeartTimes;
    }

    public Long getUeId() {
        return ueId;
    }

    public void setUeId(Long ueId) {
        this.ueId = ueId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public Integer getUeStatus() {
        return ueStatus;
    }

    public void setUeStatus(Integer ueStatus) {
        this.ueStatus = ueStatus;
    }

    public Integer getUeCollection() {
        return ueCollection;
    }

    public void setUeCollection(Integer ueCollection) {
        this.ueCollection = ueCollection;
    }

    public Timestamp getUeTime() {
        return ueTime;
    }

    public void setUeTime(Timestamp ueTime) {
        this.ueTime = ueTime;
    }

    public Integer getUeHeartRateMin() {
        return ueHeartRateMin;
    }

    public void setUeHeartRateMin(Integer ueHeartRateMin) {
        this.ueHeartRateMin = ueHeartRateMin;
    }

    public Integer getUeHeartRateMax() {
        return ueHeartRateMax;
    }

    public void setUeHeartRateMax(Integer ueHeartRateMax) {
        this.ueHeartRateMax = ueHeartRateMax;
    }

    public Integer getUeHeartRateAve() {
        return ueHeartRateAve;
    }

    public void setUeHeartRateAve(Integer ueHeartRateAve) {
        this.ueHeartRateAve = ueHeartRateAve;
    }

    public Integer getUeHeartTimes() {
        return ueHeartTimes;
    }

    public void setUeHeartTimes(Integer ueHeartTimes) {
        this.ueHeartTimes = ueHeartTimes;
    }
}

