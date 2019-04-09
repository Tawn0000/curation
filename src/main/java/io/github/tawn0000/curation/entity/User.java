package io.github.tawn0000.curation.entity;

public class User {
    //主键ID
    private Long uId;
    //微信号
    private String wcId;
    //姓名
    private String uName;
    // 性别
    private String uSex;
    // 头像
    private String uIcon;
    // 蓝牙权限(开/关）
    private String uBluetoothstauts;
    // 是否填写过调查问卷
    private String uQuarystatus;
    // 喜好标签
    private String uTag;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getWcId() {
        return wcId;
    }

    public void setWcId(String wcId) {
        this.wcId = wcId;
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

    public String getuBluetoothstauts() {
        return uBluetoothstauts;
    }

    public void setuBluetoothstauts(String uBluetoothstauts) {
        this.uBluetoothstauts = uBluetoothstauts;
    }

    public String getuQuarystatus() {
        return uQuarystatus;
    }

    public void setuQuarystatus(String uQuarystatus) {
        this.uQuarystatus = uQuarystatus;
    }

    public String getuTag() {
        return uTag;
    }

    public void setuTag(String uTag) {
        this.uTag = uTag;
    }
}