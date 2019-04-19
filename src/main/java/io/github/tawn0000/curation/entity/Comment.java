package io.github.tawn0000.curation.entity;

import io.github.tawn0000.curation.utils.DateUtil;

import java.sql.Timestamp;
import java.util.Date;

public class Comment {
    //自增评论编号
    private Long  cId;
    //用户编号
    private Long uId;
    //展览编号
    private Long eId;
    //展品编号
    private Integer cGrade;
    //评论时间
    private Timestamp cDate;
    //评论文字内容
    private String cContent;
    //评论图片
    private String cImage;

    public Comment(Long cId, Long uId, Long eId, Integer cGrade, Timestamp cDate, String cContent, String cImage) {
        this.cId = cId;
        this.uId = uId;
        this.eId = eId;
        this.cGrade = cGrade;
        this.cDate = cDate;
        this.cContent = cContent;
        this.cImage = cImage;
    }

    public Comment(Long uId, Long eId, Integer cGrade, Timestamp cDate, String cContent, String cImage) {
        this.uId = uId;
        this.eId = eId;
        this.cGrade = cGrade;
        this.cDate = cDate;
        this.cContent = cContent;
        this.cImage = cImage;
    }

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

    public Integer getcGrade() {
        return cGrade;
    }

    public void setcGrade(Integer cGrade) {
        this.cGrade = cGrade;
    }

    public Timestamp getcDate() {
        return cDate;
    }

    public void setcDate(Timestamp cDate) {
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
