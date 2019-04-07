package io.github.tawn0000.curation.entity;

public class Etag {
    //自增编号
    private Long id;
    //展览编号
    private Long eid;
    //展览标签
    private String tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
