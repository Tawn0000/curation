package io.github.tawn0000.curation.entity;

public class Etag {
    //自增编号
    private Long etId;
    //展览编号
    private Long eId;
    //展览标签
    private String eTags;

    public Long getEtId() {
        return etId;
    }

    public void setEtId(Long etId) {
        this.etId = etId;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String geteTags() {
        return eTags;
    }

    public void seteTags(String eTags) {
        this.eTags = eTags;
    }
}
