package com.jdlx.edumanageoa.activity.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jdlx.edumanageoa.R;
import com.jdlx.edumanageoa.activity.impl.usercenter.LoginActivity;
import com.jdlx.edumanageoa.activity.view.IMainView;
import com.jdlx.edumanageoa.application.MyApplication;
import com.jdlx.edumanageoa.common.Consts;
import com.jdlx.edumanageoa.common.DataEvent;
import com.jdlx.edumanageoa.customerview.CircleImageView;
import com.jdlx.edumanageoa.customerview.MyDrawerLayout;
import com.jdlx.edumanageoa.entity.Shop;
import com.jdlx.edumanageoa.entity.ShopStatisticalData;
import com.jdlx.edumanageoa.entity.User;
import com.jdlx.edumanageoa.entity.Worker;
import com.jdlx.edumanageoa.fragment.factory.ShopFragmentFactory;
import com.jdlx.edumanageoa.fragment.impl.BaseFragment;
import com.jdlx.edumanageoa.fragment.view.shop.IShopView;
import com.jdlx.edumanageoa.presenter.factory.MainViewPresenterFactory;
import com.jdlx.edumanageoa.presenter.interf.IMainViewPresenter;
import com.jdlx.edumanageoa.util.InfoUtils;
import com.jdlx.edumanageoa.util.SPUtils;
import com.jdlx.edumanageoa.util.ToastUtils;
import com.nineoldandroids.view.ViewHelper;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity implements IMainView {
    // DrawerLayout
    @BindView(R.id.drawerLayout)
    MyDrawerLayout drawerLayout;
    // 侧滑菜单
    @BindView(R.id.sv_left_menu)
    ScrollView svLeftMenu;
    // 头像
    @BindView(R.id.iv_user_head)
    CircleImageView ivUserHead;
    // 用户名
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    // 职称
    @BindView(R.id.tv_user_work_name)
    TextView tvUserWorkName;
    // 工作状态
    @BindView(R.id.tv_user_work_state)
    TextView tvUserWorkState;
    // 当前门店名
    @BindView(R.id.tv_curr_shop_name)
    TextView tvCurrShopName;
    // 营业额
    @BindView(R.id.tv_curr_shop_turnover)
    TextView tvCurrShopTurnover;
    // 单量/客量
    @BindView(R.id.tv_curr_shop_order_customer_number)
    TextView tvCurrShopOrderCustomerNumber;
    // 新增会员
    @BindView(R.id.tv_curr_shop_new_customer_number)
    TextView tvCurrShopNewCustomerNumber;

    // 门店Fragment
    private IShopView shopFragment;

    // 上一次显示的Fragment
    private BaseFragment lastFragment;

    // 切换门店
    private static final int CHANGE_SHOP = 1;

    /**
     * 主导器
     */
    IMainViewPresenter presenter;
    String oldPassword,newPassword,confirmPassword;
    AlertDialog dialog;
    EditText etDialogMainChangePasswordOld;
    EditText etDialogMainChangePasswordNew;
    EditText etDialogMainChangePasswordConfirm;

    public static boolean isForeground = false;


    /*----------------------- 极光推送开始 -------------------------*/

    /*----------------------- 极光推送结束 -------------------------*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
        // 设置全屏滑动
        setSlideAllView();

        presenter = MainViewPresenterFactory.newInstance(this);

        // 订阅EventBus
//        EventBus.getDefault().register(this);

        // 进入门店
        String currShopId = (String) SPUtils.get(this, Consts.CURR_SHOP, "");
        showShop(currShopId);
    /*----------------------- 极光推送开始 -------------------------*/

    /*----------------------- 极光推送结束 -------------------------*/

    }

    /**
     * 设置数据
     */
    private void setData() {
        // 用户信息
        User user = MyApplication.getInstance().getUser();
        if (user == null) {
            InfoUtils.showInfo(this, "请重新登录");
            startActivity(LoginActivity.class);
            finish();
            return;
        }
        // 工作者信息
        Worker worker = user.getWorker();
        if (worker == null) {
            InfoUtils.showInfo(this, "未加入门店");
            startActivity(LoginActivity.class);
            finish();
            return;
        }

        // 头像
        if (user.getPhotoUrl() != null && !"".equals(user.getPhotoUrl())) {
            Picasso.with(this).load(user.getPhotoUrl()).into(ivUserHead);
        }
        // 用户名
        tvUserName.setText(user.getName());
        // 职称
        String workName = worker.getJobname() + worker.getPostname();
        tvUserWorkName.setText(workName);
        // 工作状态
        tvUserWorkState.setText(worker.getWorkstatename());

        // 当前门店
        Shop currShop = MyApplication.getInstance().getCurrShop();
        tvCurrShopName.setText(currShop.getName());

        // 统计数据
        ShopStatisticalData statisticalData = currShop.getStatisticalData();
        if (statisticalData != null) {
            // 营业额
            tvCurrShopTurnover.setText(statisticalData.getIncome());
            // 单量/客量
            String ocn = statisticalData.getAll() + "/" + statisticalData.getMnum();
            tvCurrShopOrderCustomerNumber.setText(ocn);
            // 新增会员
            tvCurrShopNewCustomerNumber.setText(statisticalData.getNmnum());
        } else {
            // 营业额
            tvCurrShopTurnover.setText("0.00");
            // 单量/客量
            tvCurrShopOrderCustomerNumber.setText("0/0");
            // 新增会员
            tvCurrShopNewCustomerNumber.setText("0");
        }
    }

    /**
     * 设置全屏滑动
     */
    private void setSlideAllView() {
        drawerLayout.addDrawerListener(new MyDrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // 获取内容区对象
                View mContent = drawerLayout.getChildAt(0);
                // 菜单对象
                View mMenu = drawerView;
                //改变DrawLayout侧栏透明度，若不需要效果可以不设置
                ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * slideOffset);
                ViewHelper.setTranslationX(mContent,
                        mMenu.getMeasuredWidth() * slideOffset);
                ViewHelper.setPivotX(mContent, 0);
                ViewHelper.setPivotY(mContent, mContent.getMeasuredHeight() / 2);
                mContent.invalidate();
            }
        });
    }

    /**
     * 进入门店
     *
     * @param shopId 门店ID
     */
    private void showShop(String shopId) {
        if (shopFragment == null) {
            shopFragment = ShopFragmentFactory.newInstance();
        }
        showFragment(R.id.fl_main_content, lastFragment, (BaseFragment) shopFragment);
        lastFragment = (BaseFragment) shopFragment;
        // 设置门店ID
        shopFragment.setShopId(shopId);
    }

    /**
     * 打开用户信息界面
     */
    @OnClick(R.id.ll_user_info)
    public void showUserInfoView() {
        InfoUtils.showInfo(this, "正在开发中，敬请期待！");
    }

    /**
     * 切换门店
     */
    @OnClick(R.id.ll_shop_info)
    public void changeShop() {
//        startActivityForResult(new Intent(this, ChangeShopActivity.class), CHANGE_SHOP);
    }

    /**
     * 打开业绩分析界面
     */
    @OnClick(R.id.ll_performance_analysis)
    public void showPerformanceAnalysisView() {
        InfoUtils.showInfo(this, "正在开发中，敬请期待！");
    }

    /**
     * 打开客单明细界面
     */
    @OnClick(R.id.ll_order_detail)
    public void showOrderDetailView() {
        InfoUtils.showInfo(this, "正在开发中，敬请期待！");
    }

    /**
     * 打开个人设置界面
     */
    @OnClick(R.id.ll_preferences)
    public void showPreferencesView() {


        InfoUtils.showInfo(this, "正在开发中，敬请期待！");
    }

    /**
     * 打开客服咨询界面
     */
    @OnClick(R.id.ll_customer_service)
    public void showCustomerServiceView() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View
                .inflate(this, R.layout.dialog_main_customer_service, null);
        builder.setView(view);
        builder.setCancelable(true);

        final TextView tvPhoneNumber = (TextView) view
                .findViewById(R.id.tv_dialog_main_customer_service_phone_number);//取消按钮
        Button cancel = (Button) view
                .findViewById(R.id.btn_dialog_main_customer_service_cancel);//取消按钮
        Button affirm = (Button) view
                .findViewById(R.id.btn_dialog_main_customer_service_affirm);//确定按钮
        //取消或确定按钮监听事件处理
        final AlertDialog dialog = builder.create();
        dialog.show();
        closeMenu();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        affirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //拨打电话
                // 会员拨打电话
                if (tvPhoneNumber.getText() != null){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tvPhoneNumber.getText()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MainActivity.this.startActivity(intent);
                    dialog.dismiss();
                }else {
                    ToastUtils.showLong(MainActivity.this,"会员手机号为空！");
                }
            }
        });
    }

    /**
     * 打开修改密码界面
     */
    @OnClick(R.id.ll_update_password)
    public void showPasswordUpdateView() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View viewDialog = inflater.inflate(R.layout.dialog_main_change_password, null);
        ImageView ivDialogMainChangePasswordClose = (ImageView) viewDialog.findViewById(R.id.iv_dialog_main_change_password_close);
        Button btnDialogMainChangePasswordConfirm = (Button) viewDialog.findViewById(R.id.btn_dialog_main_change_password_confirm);

        etDialogMainChangePasswordOld = (EditText) viewDialog.findViewById(R.id.et_dialog_main_change_password_old);
        etDialogMainChangePasswordNew = (EditText) viewDialog.findViewById(R.id.et_dialog_main_change_password_new);
        etDialogMainChangePasswordConfirm = (EditText) viewDialog.findViewById(R.id.et_dialog_main_change_password_confirm);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.iv_dialog_main_change_password_close:
                        dialog.dismiss();
                        break;
                    case R.id.btn_dialog_main_change_password_confirm:

                        if (TextUtils.isEmpty(etDialogMainChangePasswordOld.getText().toString().trim())) {
                            ToastUtils.showLong(MainActivity.this, "请输入原密码！");
                        } else if (etDialogMainChangePasswordNew.getText().length() < 6 | etDialogMainChangePasswordConfirm.getText().length() < 6){
                            etDialogMainChangePasswordNew.setText("");
                            etDialogMainChangePasswordConfirm.setText("");
                            etDialogMainChangePasswordOld.setText("");
                            ToastUtils.showLong(MainActivity.this, "密码长度不符合规则，请重新输入！");
                        } else if (!(etDialogMainChangePasswordNew.getText().toString().trim().equals(etDialogMainChangePasswordConfirm.getText().toString().trim())) ) {
                            ToastUtils.showLong(MainActivity.this, "两次输入不同，请重新输入！");
                            etDialogMainChangePasswordNew.setText("");
                            etDialogMainChangePasswordConfirm.setText("");
                            etDialogMainChangePasswordOld.setText("");
                        } else if (etDialogMainChangePasswordNew.getText().toString().trim().equals(etDialogMainChangePasswordOld.getText().toString().trim()) | etDialogMainChangePasswordConfirm.getText().toString().trim().equals(etDialogMainChangePasswordOld.getText().toString().trim())){
                            etDialogMainChangePasswordNew.setText("");
                            etDialogMainChangePasswordConfirm.setText("");
                            etDialogMainChangePasswordOld.setText("");
                            ToastUtils.showLong(MainActivity.this, "新密码与原密码相同，请重新输入！");
                        } else {
                            // 密码
                            String newPassword = etDialogMainChangePasswordNew.getText().toString().trim();
                            // 验证原密码
                            String oldPassword = etDialogMainChangePasswordOld.getText().toString().trim();

                            // 确认提交

                            // 显示等待对话框
                            MainActivity.this.showWaitDialog(Consts.WaitDialogMessage.DATA_LOADING);
                            presenter.alterPassword(newPassword , oldPassword);

                        }

                        break;
                }
            }
        };

        ivDialogMainChangePasswordClose.setOnClickListener(onClickListener);
        btnDialogMainChangePasswordConfirm.setOnClickListener(onClickListener);

        etDialogMainChangePasswordOld.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                oldPassword = etDialogMainChangePasswordOld.getText().toString().trim();
            }
        });
        etDialogMainChangePasswordNew.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                newPassword = etDialogMainChangePasswordNew.getText().toString().trim();
            }
        });
        etDialogMainChangePasswordConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                confirmPassword = etDialogMainChangePasswordConfirm.getText().toString().trim();
            }
        });
        builder.setView(viewDialog);//添加自定义View
        builder.create();
        dialog = builder.show();
        closeMenu();



    }

    /**
     * 打开退出登录界面
     */
    @OnClick(R.id.ll_exit_login)
    public void showExitView() {
        // 清除记录的session
        SPUtils.remove(this, Consts.SESSION);
        // 清除用户ID

        // 回到登录界面
        startActivity(LoginActivity.class);
        finish();
    }

    /**
     * 打开侧滑菜单
     */
    @Override
    public void showMenu() {
        drawerLayout.openDrawer(svLeftMenu);
    }

    /**
     * 关闭侧滑菜单
     */
    public void closeMenu() {
        drawerLayout.closeDrawer(svLeftMenu);
    }

    /**
     * 更改密码成功
     *
     * @param data
     */
    @Override
    public void alterPasswordSuccess(String data) {
        // 关闭等待对话框
        this.closeWaitDialog();
        if ("1".equals(data)){
            ToastUtils.showLong(this,"原密码错误，请重新输入！");
            etDialogMainChangePasswordNew.setText("");
            etDialogMainChangePasswordConfirm.setText("");
            etDialogMainChangePasswordOld.setText("");
        }else if ("0".equals(data)){
            ToastUtils.showLong(this,"密码修改成功，请重新登录");
            dialog.dismiss();
            startActivity(LoginActivity.class);
            finish();
        }


    }

    /**
     * 更改密码失败
     *
     * @param e
     */
    @Override
    public void onAlterPasswordFail(Exception e) {
        // 关闭等待对话框
        this.closeWaitDialog();
        // 显示失败信息
        InfoUtils.showInfo(this, e.getMessage());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case CHANGE_SHOP:
                    // 进入门店
                    String currShopId = (String) SPUtils.get(this, Consts.CURR_SHOP, "");
                    showShop(currShopId);
                    break;
            }
        }
    }

    /**
     * 接收事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataEvent(DataEvent dataEvent) {
        switch (dataEvent.getType()) {
            case Consts.DataEventType.LOAD_USER_SHOP_INFO_SUCCESS: // 加载当前门店及个人信息成功
                // 设置数据
                setData();
                break;

        }
    }

    // 上一次点击返回键的时间
    long lastClickBackTime;

    @Override
    public void onBackPressed() {
        // 当前时间
        long currTime = System.currentTimeMillis();
        // 比较时间差，如果小于1.5秒，退出
        if (currTime - lastClickBackTime <= 1500) {
            super.onBackPressed();
        } else {
            lastClickBackTime = currTime;
            InfoUtils.showInfo(this, "再按一次，退出系统");
        }
    }

    @Override
    protected void onDestroy() {
        // 解除订阅
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }


}
