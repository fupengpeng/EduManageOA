package com.jdlx.edumanageoa.entity.order;

/**
 * 服务员
 */

public class Waiter {

    // 用户系统ID
    private String id;
    // 真实姓名
    private String name;
    // 平台级别
    private String level;
    // 头像
    private String PhotoUrl;
    // 说明
    private String Intro;
    //是否选中
    private boolean serve;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

    public boolean isServe() {
        return serve;
    }

    public void setServe(boolean serve) {
        this.serve = serve;
    }
}
