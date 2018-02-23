package com.jdlx.edumanageoa.model.interf;


import com.jdlx.edumanageoa.common.ObjectCallBack;
import com.jdlx.edumanageoa.entity.LoginResponseData;

/**
 * 用户业务接口
 */
public interface IUserModel {
    /**
     * 登录
     *
     * @param phoneNumber 手机号
     * @param password    密码
     * @param callBack    回调
     */
    void login(String phoneNumber, String password, final ObjectCallBack<LoginResponseData> callBack);


    /**
     * 更改密码
     *
     * @param newpwd   新密码（大于6位）
     * @param opwd     原密码
     * @param callBack 回调
     */
    void alterPassword(String newpwd, String opwd, final ObjectCallBack<String> callBack);


}
