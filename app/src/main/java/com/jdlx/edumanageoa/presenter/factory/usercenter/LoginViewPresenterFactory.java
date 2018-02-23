package com.jdlx.edumanageoa.presenter.factory.usercenter;


import com.jdlx.edumanageoa.activity.view.usercenter.ILoginView;
import com.jdlx.edumanageoa.presenter.impl.usercenter.LoginViewPresenter;
import com.jdlx.edumanageoa.presenter.interf.usercenter.ILoginViewPresenter;

/**
 * 登录界面主导器工厂
 */
public class LoginViewPresenterFactory {
    /**
     * 创建登录界面主导器对象
     *
     * @param loginView 登录界面
     * @return 登录界面主导器对象
     */
    public static ILoginViewPresenter newInstance(ILoginView loginView) {
        return new LoginViewPresenter(loginView);
    }

}
