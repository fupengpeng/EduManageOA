package com.jdlx.edumanageoa.presenter.impl;

import com.jdlx.edumanageoa.activity.view.IMainView;
import com.jdlx.edumanageoa.common.ObjectCallBack;
import com.jdlx.edumanageoa.model.factory.UserModelFactory;
import com.jdlx.edumanageoa.model.interf.IUserModel;
import com.jdlx.edumanageoa.presenter.interf.IMainViewPresenter;

/**
 * @author fupengpeng
 * @description 主界面主导器
 * @data 2018/1/17 0017 18:18
 */

public class MainViewPresenter implements IMainViewPresenter {

    // 用户业务
    private IUserModel userModel;
    // 主界面
    private IMainView mainView;

    /**
     * 构造函数
     *
     * @param mainView 主界面
     */
    public MainViewPresenter(IMainView mainView) {
        this.mainView = mainView;
        userModel = UserModelFactory.newInstance();
    }


    /**
     * 更改密码
     *
     * @param newpwd  新密码（大于6位）
     * @param opwd    原密码
     */
    @Override
    public void alterPassword(String newpwd , String opwd) {

        userModel.alterPassword(newpwd,opwd, new ObjectCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                mainView.alterPasswordSuccess(data);
            }

            @Override
            public void onFail(Exception e) {
                // 通知界面
                mainView.onAlterPasswordFail(e);
            }
        });
    }
}
