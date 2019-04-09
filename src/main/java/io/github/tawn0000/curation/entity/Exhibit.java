package io.github.tawn0000.curation.entity;

import java.util.Date;

public class Exhibit {
    //自增展品编号
    private Long e1Id;
    //展览编号
    private Long eId;
    //展品名称
    private String e1Name;
    //作者
    private String e1Author;
    //年代
    private Date e1Date;
    //图片
    private String e1Image;
    //内容介绍
    private String e1Description;

    public Long getE1Id() {
        return e1Id;
    }

    public void setE1Id(Long e1Id) {
        this.e1Id = e1Id;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String getE1Name() {
        return e1Name;
    }

    public void setE1Name(String e1Name) {
        this.e1Name = e1Name;
    }

    public String getE1Author() {
        return e1Author;
    }

    public void setE1Author(String e1Author) {
        this.e1Author = e1Author;
    }

    public Date getE1Date() {
        return e1Date;
    }

    public void setE1Date(Date e1Date) {
        this.e1Date = e1Date;
    }

    public String getE1Image() {
        return e1Image;
    }

    public void setE1Image(String e1Image) {
        this.e1Image = e1Image;
    }

    public String getE1Description() {
        return e1Description;
    }

    public void setE1Description(String e1Description) {
        this.e1Description = e1Description;
    }
}
