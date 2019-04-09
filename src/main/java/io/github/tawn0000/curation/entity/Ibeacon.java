package io.github.tawn0000.curation.entity;

public class Ibeacon {
    //自增蓝牙编号
    private Long iId;
    //UUID
    private String iUid;
    //Marjor
    private String iMajor;
    //Minor
    private String iMinor;
    //Measured_Power
    private String iMeasuredPower;
    //Status //是否被使用
    private int iStatus;
    //Connect_E1_id //被哪个展品使用
    private Long e1Id;
    //Wide
    private Float iWide;

    public Long getiId() {
        return iId;
    }

    public void setiId(Long iId) {
        this.iId = iId;
    }

    public String getiUid() {
        return iUid;
    }

    public void setiUid(String iUid) {
        this.iUid = iUid;
    }

    public String getiMajor() {
        return iMajor;
    }

    public void setiMajor(String iMajor) {
        this.iMajor = iMajor;
    }

    public String getiMinor() {
        return iMinor;
    }

    public void setiMinor(String iMinor) {
        this.iMinor = iMinor;
    }

    public String getiMeasuredPower() {
        return iMeasuredPower;
    }

    public void setiMeasuredPower(String iMeasuredPower) {
        this.iMeasuredPower = iMeasuredPower;
    }

    public int getiStatus() {
        return iStatus;
    }

    public void setiStatus(int iStatus) {
        this.iStatus = iStatus;
    }

    public Long getE1Id() {
        return e1Id;
    }

    public void setE1Id(Long e1Id) {
        this.e1Id = e1Id;
    }

    public Float getiWide() {
        return iWide;
    }

    public void setiWide(Float iWide) {
        this.iWide = iWide;
    }
}
