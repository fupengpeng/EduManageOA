package com.jdlx.edumanageoa.presenter.impl.usercenter;

import com.jdlx.edumanageoa.activity.view.usercenter.ILoginView;
import com.jdlx.edumanageoa.application.MyApplication;
import com.jdlx.edumanageoa.common.Consts;
import com.jdlx.edumanageoa.common.ObjectCallBack;
import com.jdlx.edumanageoa.entity.LoginResponseData;
import com.jdlx.edumanageoa.entity.Shop;
import com.jdlx.edumanageoa.model.factory.UserModelFactory;
import com.jdlx.edumanageoa.model.interf.IUserModel;
import com.jdlx.edumanageoa.presenter.interf.usercenter.ILoginViewPresenter;
import com.jdlx.edumanageoa.util.SPUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录界面主导器
 */
public class LoginViewPresenter implements ILoginViewPresenter {
    // 用户业务
    private IUserModel userModel;
    // 登录界面
    private ILoginView loginView;

    /**
     * 构造函数
     *
     * @param loginView 登录界面
     */
    public LoginViewPresenter(ILoginView loginView) {
        this.loginView = loginView;
        userModel = UserModelFactory.newInstance();
    }

    /**
     * 登录
     *
     * @param phoneNumber 手机号
     * @param password    密码
     */
    @Override
    public void login(String phoneNumber, String password) {
        // 登录
        userModel.login(phoneNumber, password, new ObjectCallBack<LoginResponseData>() {
            @Override
            public void onSuccess(LoginResponseData data) {
                // 判断门店信息是否存在
                if(data.getUshop()==null || data.getUshop().size()==0){
                    // 通知界面
                    loginView.onLoginFail(new Exception("未加入门店"));
                    return;
                }

                // 保存session
                SPUtils.put(MyApplication.getInstance(), Consts.SESSION, data.getSessionId());
                // 保存用户信息
                MyApplication.getInstance().setUser(data.getUinfo());
                // 保存门店信息
                // 过滤重复
                List<Shop> shopList = new ArrayList<>();
                for(Shop shop: data.getUshop()){
                    if(!shopList.contains(shop)){
                        shopList.add(shop);
                    }
                }
                MyApplication.getInstance().setShops(shopList);
                // 通知界面
                loginView.onLoginSuccess();
            }

            @Override
            public void onFail(Exception e) {
                // 通知界面
                loginView.onLoginFail(e);
            }
        });
    }
}
