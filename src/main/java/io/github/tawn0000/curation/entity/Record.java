package io.github.tawn0000.curation.entity;

import java.sql.Time;
import java.sql.Timestamp;
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
    private Timestamp rBeginTime;
    //结束时间
    private Timestamp rEndTime;
    //停留时长
    private Integer rInterval;

    public Record(Long rId, Long uId, Long eId, Long e1Id, Timestamp rBeginTime, Timestamp rEndTime, Integer rInterval) {
        this.rId = rId;
        this.uId = uId;
        this.eId = eId;
        this.e1Id = e1Id;
        this.rBeginTime = rBeginTime;
        this.rEndTime = rEndTime;
        this.rInterval = rInterval;
    }

    public Record(Long uId, Long eId, Long e1Id, Timestamp rBeginTime, Timestamp rEndTime, Integer rInterval) {
        this.uId = uId;
        this.eId = eId;
        this.e1Id = e1Id;
        this.rBeginTime = rBeginTime;
        this.rEndTime = rEndTime;
        this.rInterval = rInterval;
    }

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

    public Timestamp getrBeginTime() {
        return rBeginTime;
    }

    public void setrBeginTime(Timestamp rBeginTime) {
        this.rBeginTime = rBeginTime;
    }

    public Timestamp getrEndTime() {
        return rEndTime;
    }

    public void setrEndTime(Timestamp rEndTime) {
        this.rEndTime = rEndTime;
    }

    public Integer getrInterval() {
        return rInterval;
    }

    public void setrInterval(Integer rInterval) {
        this.rInterval = rInterval;
    }
}
