package io.github.tawn0000.curation.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Exhibition {
    //自增展览编号
    private Long eId;
    //名称
    private String eName;
    //地点
    private String eAddress;
    //开始时间
    private Timestamp e_Begin_Date;
    //结束时间
    private Timestamp e_End_Date;
    //价格
    private int ePrice;
    //展览描述
    private String eDescription;
    //图片
    private String eImage;
    //视频
    private String eVideo;
    //负责人
    private String ePersonCharge;

    public Exhibition(Long eId, String eName, String eAddress, Timestamp e_Begin_Date, Timestamp e_End_Date, int ePrice, String eDescription, String eImage, String eVideo, String ePersonCharge) {
        this.eId = eId;
        this.eName = eName;
        this.eAddress = eAddress;
        this.e_Begin_Date = e_Begin_Date;
        this.e_End_Date = e_End_Date;
        this.ePrice = ePrice;
        this.eDescription = eDescription;
        this.eImage = eImage;
        this.eVideo = eVideo;
        this.ePersonCharge = ePersonCharge;
    }

    public Exhibition(String eName, String eAddress, Timestamp e_Begin_Date, Timestamp e_End_Date, int ePrice, String eDescription, String eImage, String eVideo, String ePersonCharge) {
        this.eName = eName;
        this.eAddress = eAddress;
        this.e_Begin_Date = e_Begin_Date;
        this.e_End_Date = e_End_Date;
        this.ePrice = ePrice;
        this.eDescription = eDescription;
        this.eImage = eImage;
        this.eVideo = eVideo;
        this.ePersonCharge = ePersonCharge;
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

    public Timestamp getE_Begin_Date() {
        return e_Begin_Date;
    }

    public void setE_Begin_Date(Timestamp e_Begin_Date) {
        this.e_Begin_Date = e_Begin_Date;
    }

    public Timestamp getE_End_Date() {
        return e_End_Date;
    }

    public void setE_End_Date(Timestamp e_End_Date) {
        this.e_End_Date = e_End_Date;
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

    public String geteVideo() {
        return eVideo;
    }

    public void seteVideo(String eVideo) {
        this.eVideo = eVideo;
    }

    public String getePersonCharge() {
        return ePersonCharge;
    }

    public void setePersonCharge(String ePersonCharge) {
        this.ePersonCharge = ePersonCharge;
    }
}
