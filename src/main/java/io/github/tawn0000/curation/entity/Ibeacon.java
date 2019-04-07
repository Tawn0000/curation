package io.github.tawn0000.curation.entity;

public class Ibeacon {
    //自增蓝牙编号
    private Long id;
    //UUID
    private String uid;
    //Marjor
    private String major;
    //Minor
    private String minor;
    //Measured_Power
    private String power;
    //Status
    private boolean status;
    //Connect_E1_id
    private Long e1id;
    //Wide
    private Float wide;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getE1id() {
        return e1id;
    }

    public void setE1id(Long e1id) {
        this.e1id = e1id;
    }

    public Float getWide() {
        return wide;
    }

    public void setWide(Float wide) {
        this.wide = wide;
    }
}
