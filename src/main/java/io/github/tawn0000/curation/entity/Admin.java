package io.github.tawn0000.curation.entity;

public class Admin {
    //主键ID
    private int aId;
    //微信号
    private String wcId;
    //密码
    private String aPassword;
    //姓名
    private String aName;
    //权限级别(0-1,0代表最高级别，1代表可以添加展览信息）
    private int aLevel;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
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

    public int getaLevel() {
        return aLevel;
    }

    public void setaLevel(int aLevel) {
        this.aLevel = aLevel;
    }
}