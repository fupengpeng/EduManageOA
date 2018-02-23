package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * 登录的响应数据
 */
public class LoginResponseData {
    // 门店列表
    private List<Shop> ushop;
    // 用户信息
    private User uinfo;
    // 用户登录后的验证I
    private String sessionId;

    public List<Shop> getUshop() {
        return ushop;
    }

    public void setUshop(List<Shop> ushop) {
        this.ushop = ushop;
    }

    public User getUinfo() {
        return uinfo;
    }

    public void setUinfo(User uinfo) {
        this.uinfo = uinfo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
