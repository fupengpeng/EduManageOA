package com.jdlx.edumanageoa.activity.impl.usercenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.jdlx.edumanageoa.R;
import com.jdlx.edumanageoa.activity.impl.BaseActivity;
import com.jdlx.edumanageoa.activity.impl.MainActivity;
import com.jdlx.edumanageoa.activity.view.usercenter.ILoginView;
import com.jdlx.edumanageoa.application.MyApplication;
import com.jdlx.edumanageoa.common.Consts;
import com.jdlx.edumanageoa.entity.Shop;
import com.jdlx.edumanageoa.presenter.factory.usercenter.LoginViewPresenterFactory;
import com.jdlx.edumanageoa.presenter.interf.usercenter.ILoginViewPresenter;
import com.jdlx.edumanageoa.util.AccountUtils;
import com.jdlx.edumanageoa.util.InfoUtils;
import com.jdlx.edumanageoa.util.SPUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity implements ILoginView {
    // 手机号
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    // 密码
    @BindView(R.id.et_password)
    EditText etPassword;

    // 主导器
    ILoginViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_login);

        // 创建主导器
        presenter = LoginViewPresenterFactory.newInstance(this);
    }


    /**
     * 登录
     */
    @OnClick(R.id.btn_login)
    public void login() {
        // 获取手机号和密码
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        // 验证手机号
        if (!AccountUtils.checkPhoneNum(phoneNumber, this, etPhoneNumber)) {
            return;
        }
        // 验证密码
        if (!AccountUtils.checkPassword(password, this, etPassword)) {
            return;
        }
        // 登录
        // 显示等待对话框
        showWaitDialog(Consts.WaitDialogMessage.LOGINING);
        presenter.login(phoneNumber, password);
    }

    /**
     * 通过验证码登录
     */
    @OnClick(R.id.tv_login_by_validate_code)
    public void loginByValidateCode() {
        //
        InfoUtils.showInfo(this, "正在开发中");
    }

    /**
     * 当登录成功
     */
    @Override
    public void onLoginSuccess() {
        // 关闭等待对话框
        closeWaitDialog();
        // 获取存储的门店ID
        String currShopId = (String) SPUtils.get(this, Consts.CURR_SHOP, "");
        if (TextUtils.isEmpty(currShopId)) {
            // 去选择门店
//            startActivity(ChangeShopActivity.class);
            finish();
        } else {
            // 判断门店是否存在
            List<Shop> shopList = MyApplication.getInstance().getShops();
            for (Shop shop : shopList) {
                if(currShopId.equals(shop.getId())){
                    // 跳转到主界面
                    startActivity(MainActivity.class);
                    finish();
                    return;
                }
            }

            // 去选择门店
            SPUtils.remove(this, Consts.CURR_SHOP);
//            startActivity(ChangeShopActivity.class);
            finish();
        }
    }

    /**
     * 当登录失败
     */
    @Override
    public void onLoginFail(Exception e) {
        // 关闭等待对话框
        closeWaitDialog();
        // 显示失败信息
        InfoUtils.showInfo(this, e.getMessage());
    }
}
