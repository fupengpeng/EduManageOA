package com.jdlx.edumanageoa.entity.response;


import com.jdlx.edumanageoa.entity.LoginResponseData;

/**
 * 登录的响应
 */
public class LoginResponse extends BaseResponse {
    /**
     * 登录的响应数据
     */
    private LoginResponseData data;

    public LoginResponseData getData() {
        return data;
    }

    public void setData(LoginResponseData data) {
        this.data = data;
    }
}
