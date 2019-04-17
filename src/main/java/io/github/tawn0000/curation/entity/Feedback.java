package io.github.tawn0000.curation.entity;

import java.sql.Timestamp;

public class Feedback {
    //自增编号
    private Long fId;
    //用户编号
    private Long uId;
    //反馈内容
    private String fContent;
    //图片
    private String fImage;
    //电话
    private String fPhoneNumber;
    //反馈时间
    private Timestamp fTime;

    public Feedback(Long fId, Long uId, String fContent, String fImage, String fPhoneNumber, Timestamp fTime) {
        this.fId = fId;
        this.uId = uId;
        this.fContent = fContent;
        this.fImage = fImage;
        this.fPhoneNumber = fPhoneNumber;
        this.fTime = fTime;
    }

    public Feedback(Long uId, String fContent, String fImage, String fPhoneNumber, Timestamp fTime) {
        this.uId = uId;
        this.fContent = fContent;
        this.fImage = fImage;
        this.fPhoneNumber = fPhoneNumber;
        this.fTime = fTime;
    }

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getfContent() {
        return fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    public String getfImage() {
        return fImage;
    }

    public void setfImage(String fImage) {
        this.fImage = fImage;
    }

    public String getfPhoneNumber() {
        return fPhoneNumber;
    }

    public void setfPhoneNumber(String fPhoneNumber) {
        this.fPhoneNumber = fPhoneNumber;
    }

    public Timestamp getfTime() {
        return fTime;
    }

    public void setfTime(Timestamp fTime) {
        this.fTime = fTime;
    }
}
