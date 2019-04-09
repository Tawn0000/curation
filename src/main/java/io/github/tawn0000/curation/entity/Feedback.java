package io.github.tawn0000.curation.entity;

public class Feedback {
    //自增编号
    private Long fId;
    //用户编号
    private Long uId;
    //反馈内容
    private String fContent;
    //图片
    private String fImage;

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
}
