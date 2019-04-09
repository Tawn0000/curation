package io.github.tawn0000.curation.entity;

import java.util.Date;

public class Record {
    //自增编号
    private Long rId;
    //用户编号
    private Long uId;
    //展览编号
    private Long eId;
    //展品编号
    private Long e1Id;
    //开始时间
    private Date rBeginTime;
    //结束时间
    private Date rEndTime;
    //停留时长
    private int rInterval;
    //心率
    private int rHeartRate;

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
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

    public Long getE1Id() {
        return e1Id;
    }

    public void setE1Id(Long e1Id) {
        this.e1Id = e1Id;
    }

    public Date getrBeginTime() {
        return rBeginTime;
    }

    public void setrBeginTime(Date rBeginTime) {
        this.rBeginTime = rBeginTime;
    }

    public Date getrEndTime() {
        return rEndTime;
    }

    public void setrEndTime(Date rEndTime) {
        this.rEndTime = rEndTime;
    }

    public int getrInterval() {
        return rInterval;
    }

    public void setrInterval(int rInterval) {
        this.rInterval = rInterval;
    }

    public int getrHeartRate() {
        return rHeartRate;
    }

    public void setrHeartRate(int rHeartRate) {
        this.rHeartRate = rHeartRate;
    }
}
