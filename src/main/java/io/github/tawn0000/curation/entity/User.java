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
    private String uBluetoothStauts;
    // 是否填写过调查问卷
    private String uQuaryStatus;
    // 喜好标签
    private String uTag;

    public User(String wcId, String uName, String uSex, String uIcon, String uBluetoothStauts, String uQuaryStatus, String uTag) {
        this.wcId = wcId;
        this.uName = uName;
        this.uSex = uSex;
        this.uIcon = uIcon;
        this.uBluetoothStauts = uBluetoothStauts;
        this.uQuaryStatus = uQuaryStatus;
        this.uTag = uTag;
    }

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

    public String getuBluetoothStauts() {
        return uBluetoothStauts;
    }

    public void setuBluetoothStauts(String uBluetoothStauts) {
        this.uBluetoothStauts = uBluetoothStauts;
    }

    public String getuQuaryStatus() {
        return uQuaryStatus;
    }

    public void setuQuaryStatus(String uQuaryStatus) {
        this.uQuaryStatus = uQuaryStatus;
    }

    public String getuTag() {
        return uTag;
    }

    public void setuTag(String uTag) {
        this.uTag = uTag;
    }
}