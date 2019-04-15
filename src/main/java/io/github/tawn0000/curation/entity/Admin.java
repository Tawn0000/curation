package io.github.tawn0000.curation.entity;

public class Admin {
    //主键ID
    private Integer aId;
    //微信号
    private String wcId;
    //密码
    private String aPassword;
    //姓名
    private String aName;
    //权限级别(0-1,0代表最高级别，1代表可以添加展览信息）
    private Integer aLevel;

    public Admin(Integer aId, String wcId, String aPassword, String aName, Integer aLevel) {
        this.aId = aId;
        this.wcId = wcId;
        this.aPassword = aPassword;
        this.aName = aName;
        this.aLevel = aLevel;
    }

    public Admin(String wcId, String aPassword, String aName, Integer aLevel) {
        this.wcId = wcId;
        this.aPassword = aPassword;
        this.aName = aName;
        this.aLevel = aLevel;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getWcId() {
        return wcId;
    }

    public void setWcId(String wcId) {
        this.wcId = wcId;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Integer getaLevel() {
        return aLevel;
    }

    public void setaLevel(Integer aLevel) {
        this.aLevel = aLevel;
    }
}