package io.github.tawn0000.curation.entity;

import java.util.Date;

public class Comment {
    //自增评论编号
    private Long  cId;
    //用户编号
    private Long uId;
    //展览编号
    private Long eId;
    //展品编号
    private Long e1Id;
    //评论时间
    private Date cDate;
    //评论文字内容
    private String cContent;
    //评论图片
    private String cImage;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
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

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }
}
