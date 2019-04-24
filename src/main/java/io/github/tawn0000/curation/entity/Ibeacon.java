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
    private Integer iStatus;
    //Connect_E1_id //被哪个展品使用
    private Long e1Id;
    //Wide
    private Float iWide;

    public Ibeacon(String iUid, String iMajor, String iMinor, String iMeasuredPower, Integer iStatus, Long e1Id, Float iWide) {
        this.iUid = iUid;
        this.iMajor = iMajor;
        this.iMinor = iMinor;
        this.iMeasuredPower = iMeasuredPower;
        this.iStatus = iStatus;
        this.e1Id = e1Id;
        this.iWide = iWide;
    }

    public Ibeacon(Long iId, String iUid, String iMajor, String iMinor, String iMeasuredPower, Integer iStatus, Long e1Id, Float iWide) {
        this.iId = iId;
        this.iUid = iUid;
        this.iMajor = iMajor;
        this.iMinor = iMinor;
        this.iMeasuredPower = iMeasuredPower;
        this.iStatus = iStatus;
        this.e1Id = e1Id;
        this.iWide = iWide;
    }

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

    public Integer getiStatus() {
        return iStatus;
    }

    public void setiStatus(Integer iStatus) {
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
