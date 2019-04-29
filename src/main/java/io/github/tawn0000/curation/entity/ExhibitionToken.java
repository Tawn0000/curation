package io.github.tawn0000.curation.entity;

import java.sql.Timestamp;

public class ExhibitionToken {
    //自增展览编号
    private Long eId;
    //名称
    private String eName;
    //地点
    private String eAddress;
    //开始时间
    private Timestamp eBeginDate;
    //结束时间
    private Timestamp dEndDate;
    //价格
    private int ePrice;
    //展览描述
    private String eDescription;
    //图片
    private String eImage;

    public ExhibitionToken(Long eId, String eName, String eAddress, Timestamp eBeginDate, Timestamp dEndDate, int ePrice, String eDescription, String eImage) {
        this.eId = eId;
        this.eName = eName;
        this.eAddress = eAddress;
        this.eBeginDate = eBeginDate;
        this.dEndDate = dEndDate;
        this.ePrice = ePrice;
        this.eDescription = eDescription;
        this.eImage = eImage;
    }

    public ExhibitionToken(Exhibition exhibition)
    {
        this.eId = exhibition.geteId();
        this.eName = exhibition.geteName();
        this.eAddress = exhibition.geteAddress();
        this.eBeginDate = exhibition.getE_Begin_Date();
        this.eBeginDate = exhibition.getE_End_Date();
        this.ePrice = exhibition.getePrice();
        this.eDescription = exhibition.geteDescription();
        this.eImage = exhibition.geteImage();
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteAddress() {
        return eAddress;
    }

    public void seteAddress(String eAddress) {
        this.eAddress = eAddress;
    }

    public Timestamp geteBeginDate() {
        return eBeginDate;
    }

    public void seteBeginDate(Timestamp eBeginDate) {
        this.eBeginDate = eBeginDate;
    }

    public Timestamp getdEndDate() {
        return dEndDate;
    }

    public void setdEndDate(Timestamp dEndDate) {
        this.dEndDate = dEndDate;
    }

    public int getePrice() {
        return ePrice;
    }

    public void setePrice(int ePrice) {
        this.ePrice = ePrice;
    }

    public String geteDescription() {
        return eDescription;
    }

    public void seteDescription(String eDescription) {
        this.eDescription = eDescription;
    }

    public String geteImage() {
        return eImage;
    }

    public void seteImage(String eImage) {
        this.eImage = eImage;
    }
}
