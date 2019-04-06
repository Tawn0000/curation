package io.github.tawn0000.curation.entity;

public class Admin {
    //主键ID
    private Long id;
    //微信号
    private String wc;
    //密码
    private String password;
    //姓名
    private String name;
    //权限级别(0-1,0代表最高级别，1代表可以添加展览信息）
    private int level;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
