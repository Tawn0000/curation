package io.github.tawn0000.curation.entity;

public class UE {
    //自增编号
    private Long ueId;
    //用户编号
    private Long uId;
    //展览编号
    private Long eId;
    //状态（0未报名，1已报名，2正在参加，3已参加）
    private int ueStatus;

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

    public int getUeStatus() {
        return ueStatus;
    }

    public void setUeStatus(int ueStatus) {
        this.ueStatus = ueStatus;
    }
}
