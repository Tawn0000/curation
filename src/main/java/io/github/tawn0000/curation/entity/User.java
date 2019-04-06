package io.github.tawn0000.curation.entity;

public class User {
    //主键ID
    private Long id;
    //微信号
    private String wc;
    //姓名
    private String name;
    // 性别
    private String sex;
    // 头像
    private String icon;
    // 蓝牙权限(开/关）
    private Boolean bluetoothstauts;
    // 是否填写过调查问卷
    private Boolean quarystatus;
    // 喜好标签
    private String tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWc() {
        return wc;
    }

    public void setWc(String wc) {
        this.wc = wc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getBluetoothstauts() {
        return bluetoothstauts;
    }

    public void setBluetoothstauts(Boolean bluetoothstauts) {
        this.bluetoothstauts = bluetoothstauts;
    }

    public Boolean getQuarystatus() {
        return quarystatus;
    }

    public void setQuarystatus(Boolean quarystatus) {
        this.quarystatus = quarystatus;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
