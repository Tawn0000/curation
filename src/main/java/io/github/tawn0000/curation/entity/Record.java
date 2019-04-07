package io.github.tawn0000.curation.entity;

import java.util.Date;

public class Record {
    //自增编号
    private Long id;
    //用户编号
    private Long uid;
    //展览编号
    private Long eid;
    //展品编号
    private Long e1id;
    //开始时间
    private Date begin;
    //结束时间
    private Date end;
    //停留时长
    private Long interval;
    //心率
    private Long rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Long getE1id() {
        return e1id;
    }

    public void setE1id(Long e1id) {
        this.e1id = e1id;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }
}
