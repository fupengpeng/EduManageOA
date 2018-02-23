package com.jdlx.edumanageoa.fragment.impl.shop;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jdlx.edumanageoa.R;
import com.jdlx.edumanageoa.activity.impl.BaseActivity;
import com.jdlx.edumanageoa.activity.view.IMainView;
import com.jdlx.edumanageoa.application.MyApplication;
import com.jdlx.edumanageoa.common.Consts;
import com.jdlx.edumanageoa.common.DataEvent;
import com.jdlx.edumanageoa.customerview.CircleImageView;
import com.jdlx.edumanageoa.entity.Shop;
import com.jdlx.edumanageoa.entity.ShopStatisticalData;
import com.jdlx.edumanageoa.fragment.impl.BaseFragment;
import com.jdlx.edumanageoa.fragment.view.shop.IShopView;
import com.jdlx.edumanageoa.presenter.factory.shop.ShopViewPresenterFactory;
import com.jdlx.edumanageoa.presenter.interf.shop.IShopViewPresenter;
import com.jdlx.edumanageoa.util.InfoUtils;
import com.jdlx.edumanageoa.util.LogUtils;
import com.jdlx.edumanageoa.util.ToastUtils;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 门店
 */
public class ShopFragment extends BaseFragment implements IShopView {
    // 门店logo
    @BindView(R.id.rl_shop_logo)
    RelativeLayout rlShopLogo;
    @BindView(R.id.iv_shop_logo)
    CircleImageView ivShopLogo;
    // 店名
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    // 订单信息
    @BindView(R.id.tv_order_info)
    TextView tvOrderInfo;

    // 主导器
    private IShopViewPresenter presenter;

    // 标识是否创建了界面
    private boolean isViewCreate = false;
    // 门店ID
    private String shopId;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState, R.layout.fragment_shop);
        // 创建主导器
        presenter = ShopViewPresenterFactory.newInstance(this);
        // 设置logo白色边框宽度
        ivShopLogo.setBorderWidth(15);
        // 标识创建了界面
        isViewCreate = true;
        if (!TextUtils.isEmpty(shopId)) {
            // 显示等待对话框
            ((BaseActivity) getActivity()).showWaitDialog(Consts.WaitDialogMessage.DATA_LOADING);
            // 加载门店数据
            presenter.loadUserShopInfo(shopId);
        }



        return view;
    }



    /**
     * 设置门店ID
     *
     * @param shopId 门店ID
     */
    @Override
    public void setShopId(String shopId) {
        this.shopId = shopId;
        if (isViewCreate) {
            // 显示等待对话框
            ((BaseActivity) getActivity()).showWaitDialog(Consts.WaitDialogMessage.DATA_LOADING);
            // 加载门店数据
            presenter.loadUserShopInfo(shopId);
        }
    }

    /**
     * 设置数据
     */
    private void setData() {
        Shop shop = MyApplication.getInstance().getCurrShop();
        // 店名
        tvShopName.setText(shop.getName());
        // logo
        if (!TextUtils.isEmpty(shop.getImageurl())) {
            Picasso.with(getActivity()).load(shop.getImageurl()).into(ivShopLogo);
        }
        // 订单信息
        ShopStatisticalData statisticalData = shop.getStatisticalData();
        String orderInfo = "订单总数:" + statisticalData.getAll() + "件，" +
                "服务中:" + statisticalData.getStart() + "件，" +
                "待接:" + statisticalData.getPrep() + "件";
        tvOrderInfo.setText(orderInfo);

        // 动画
        float y = rlShopLogo.getY();
        ObjectAnimator anim = ObjectAnimator.ofFloat(rlShopLogo, "y",
                -y - rlShopLogo.getHeight(), y);
        anim.setDuration(1500);
        anim.setInterpolator(new BounceInterpolator());
        anim.start(); //开始执行属性动画
        rlShopLogo.setVisibility(View.VISIBLE);

    }



    /**
     * 当加载当前门店及个人信息成功
     */
    @Override
    public void onLoadUserShopInfoSuccess() {
        // 关闭等待对话框
        ((BaseActivity) getActivity()).closeWaitDialog();
        // 发送加载当前门店及个人信息成功事件
        EventBus.getDefault().post(new DataEvent(Consts.DataEventType.LOAD_USER_SHOP_INFO_SUCCESS));
        // 设置数据
        setData();
    }

    /**
     * 当加载当前门店及个人信息失败
     */
    @Override
    public void onLoadUserShopInfoFail(Exception e) {
        // 关闭等待对话框
        ((BaseActivity) getActivity()).closeWaitDialog();
        // 显示失败信息
        InfoUtils.showInfo(getActivity(), e.getMessage());
    }

    /**
     * 一键下单
     */
    @OnClick(R.id.ll_order)
    public void order() {
        LogUtils.e("一键下单");
        ToastUtils.showLong(getContext(),"一键下单");
    }

    /**
     * 客户建档
     */
    @OnClick(R.id.ll_customs_documentation)
    public void showCustomsDocumentation() {
        LogUtils.e("客户建档");
        ToastUtils.showLong(getContext(),"客户建档");
    }

    /**
     * 服务队列
     */
    @OnClick(R.id.ll_service_queue)
    public void showServiceQueue() {
        LogUtils.e("客户建档");
        ToastUtils.showLong(getContext(),"客户建档");

    }

    /**
     * 顾客账单
     */
    @OnClick(R.id.ll_customer_bill)
    public void showCustomerBill() {
        LogUtils.e("客户建档");
        ToastUtils.showLong(getContext(),"客户建档");
    }

    /**
     * 消息
     */
    @OnClick(R.id.ll_message)
    public void showMessage() {
//        InfoUtils.showInfo(getActivity(), "正在开发中，敬请期待！");
        // TODO: 2018/1/18 0018   接收服务器推送的消息（预约id、店员信息、客户信息等）
        LogUtils.e("客户建档");
        ToastUtils.showLong(getContext(),"客户建档");
    }

    /**
     * 绩效
     */
    @OnClick(R.id.ll_performance)
    public void showPerformance() {
        InfoUtils.showInfo(getActivity(), "正在开发中，敬请期待！");
    }

    /**
     * 预约
     */
    @OnClick(R.id.ll_appoint)
    public void showAppointment() {
        InfoUtils.showInfo(getActivity(), "正在开发中，敬请期待！");
    }

    /**
     * 报表
     */
    @OnClick(R.id.ll_report)
    public void showReport() {

        InfoUtils.showInfo(getActivity(), "正在开发中，敬请期待！");
    }

    /**
     * 会员
     */
    @OnClick(R.id.ll_member)
    public void showMember() {
        InfoUtils.showInfo(getActivity(), "正在开发中，敬请期待！");
    }

    /**
     * 设置
     */
    @OnClick(R.id.ll_setup)
    public void setup() {
        InfoUtils.showInfo(getActivity(), "正在开发中，敬请期待！");

    }

    /**
     * 打开侧滑菜单
     */
    @OnClick(R.id.iv_show_menu)
    public void showMenu() {
        ((IMainView) getActivity()).showMenu();
    }

    /**
     * 二维码
     */
    @OnClick(R.id.iv_qrcode)
    public void showQrcode() {
        InfoUtils.showInfo(getActivity(), "正在开发中，敬请期待！");
    }


}
