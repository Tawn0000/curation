package io.github.tawn0000.curation.entity;

public class UE {
    //自增编号
    private Long id;
    //用户编号
    private Long uid;
    //展览编号
    private Long eid;
    //状态（未报名，已报名，正在参加，已参加）
    private Long status;

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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
