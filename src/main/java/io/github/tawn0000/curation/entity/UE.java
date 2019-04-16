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

    private boolean ueCollection;

    private Timestamp ueTime;

    public UE(Long ueId, Long uId, Long eId, Integer ueStatus, boolean ueCollection, Timestamp ueTime) {
        this.ueId = ueId;
        this.uId = uId;
        this.eId = eId;
        this.ueStatus = ueStatus;
        this.ueCollection = ueCollection;
        this.ueTime = ueTime;
    }

    public UE(Long uId, Long eId, Integer ueStatus, boolean ueCollection, Timestamp ueTime) {
        this.uId = uId;
        this.eId = eId;
        this.ueStatus = ueStatus;
        this.ueCollection = ueCollection;
        this.ueTime = ueTime;
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

    public boolean isUeCollection() {
        return ueCollection;
    }

    public void setUeCollection(boolean ueCollection) {
        this.ueCollection = ueCollection;
    }

    public Timestamp getUeTime() {
        return ueTime;
    }

    public void setUeTime(Timestamp ueTime) {
        this.ueTime = ueTime;
    }
}
