package io.github.tawn0000.curation.entity;

public class User {
    //主键ID
    private Long uId;
    //微信号
    private String openId;
    //姓名
    private String uName;
    // 性别
    private String uSex;
    // 头像
    private String uIcon;
    // 是否填写过调查问卷
    private String uQueryStatus;
    // 喜好标签
    private String uTag;

    public User(Long uId, String openId, String uName, String uSex, String uIcon, String uQueryStatus, String uTag) {
        this.uId = uId;
        this.openId = openId;
        this.uName = uName;
        this.uSex = uSex;
        this.uIcon = uIcon;
        this.uQueryStatus = uQueryStatus;
        this.uTag = uTag;
    }

    public User(String openId, String uName, String uSex, String uIcon, String uQueryStatus, String uTag) {
        this.openId = openId;
        this.uName = uName;
        this.uSex = uSex;
        this.uIcon = uIcon;
        this.uQueryStatus = uQueryStatus;
        this.uTag = uTag;
    }

    public User(String openId) {
        this.openId = openId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuIcon() {
        return uIcon;
    }

    public void setuIcon(String uIcon) {
        this.uIcon = uIcon;
    }

    public String getuQueryStatus() {
        return uQueryStatus;
    }

    public void setuQueryStatus(String uQueryStatus) {
        this.uQueryStatus = uQueryStatus;
    }

    public String getuTag() {
        return uTag;
    }

    public void setuTag(String uTag) {
        this.uTag = uTag;
    }
}