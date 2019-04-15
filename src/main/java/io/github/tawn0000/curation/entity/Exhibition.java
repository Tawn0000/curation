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
    //时间
    private Timestamp eDate;
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

    public Exhibition(String eName, String eAddress, Timestamp eDate, int ePrice, String eDescription, String eImage, String eVideo, String ePersonCharge) {
        this.eName = eName;
        this.eAddress = eAddress;
        this.eDate = eDate;
        this.ePrice = ePrice;
        this.eDescription = eDescription;
        this.eImage = eImage;
        this.eVideo = eVideo;
        this.ePersonCharge = ePersonCharge;
    }

    public Exhibition(Long eId, String eName, String eAddress, Timestamp eDate, int ePrice, String eDescription, String eImage, String eVideo, String ePersonCharge) {
        this.eId = eId;
        this.eName = eName;
        this.eAddress = eAddress;
        this.eDate = eDate;
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

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Timestamp eDate) {
        this.eDate = eDate;
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
