package com.jdlx.edumanageoa.presenter.impl.shop;

import com.jdlx.edumanageoa.application.MyApplication;
import com.jdlx.edumanageoa.common.Consts;
import com.jdlx.edumanageoa.common.ObjectCallBack;
import com.jdlx.edumanageoa.entity.LoadUserShopInfoResponseData;
import com.jdlx.edumanageoa.entity.ShopStatisticalData;
import com.jdlx.edumanageoa.entity.User;
import com.jdlx.edumanageoa.fragment.view.shop.IShopView;
import com.jdlx.edumanageoa.model.factory.ShopModelFactory;
import com.jdlx.edumanageoa.model.interf.IShopModel;
import com.jdlx.edumanageoa.presenter.interf.shop.IShopViewPresenter;
import com.jdlx.edumanageoa.util.SPUtils;

/**
 * 门店界面主导器
 */
public class ShopViewPresenter implements IShopViewPresenter {
    // 门店业务
    private IShopModel shopModel;
    // 门店界面
    private IShopView shopView;

    /**
     * 构造函数
     *
     * @param shopView 门店界面
     */
    public ShopViewPresenter(IShopView shopView) {
        this.shopView = shopView;
        shopModel = ShopModelFactory.newInstance();
    }

    /**
     * 加载当前门店及个人信息
     *
     * @param shopId 门店ID
     */
    @Override
    public void loadUserShopInfo(final String shopId) {
        User user = MyApplication.getInstance().getUser();
        String sessionId = (String) SPUtils.get(MyApplication.getInstance(), Consts.SESSION, "x");
        shopModel.loadUserShopInfo(shopId, user.getId(), sessionId, new ObjectCallBack<LoadUserShopInfoResponseData>() {
            @Override
            public void onSuccess(LoadUserShopInfoResponseData data) {
                // 保存用户在当前门店中的工作信息
                MyApplication.getInstance().getUser().setWorker(data.getUser());
                // 保存当前门店信息
                MyApplication.getInstance().setCurrShop(data.getShop());

                // 加载当前门店的统计数据
                loadOrderCount(shopId);
            }

            @Override
            public void onFail(Exception e) {
                // 通知界面
                shopView.onLoadUserShopInfoFail(e);
            }
        });
    }

    /**
     * 加载当前门店的统计数据
     *
     * @param shopId 门店ID
     */
    @Override
    public void loadOrderCount(String shopId) {
        User user = MyApplication.getInstance().getUser();
        String sessionId = (String) SPUtils.get(MyApplication.getInstance(), Consts.SESSION, "x");
        shopModel.loadOrderCount(shopId, user.getId(), sessionId, new ObjectCallBack<ShopStatisticalData>() {
            @Override
            public void onSuccess(ShopStatisticalData data) {
                // 保存当前门店的统计数据
                MyApplication.getInstance().getCurrShop().setStatisticalData(data);
                // 通知界面
                shopView.onLoadUserShopInfoSuccess();
            }

            @Override
            public void onFail(Exception e) {
                // 通知界面
                shopView.onLoadUserShopInfoFail(e);
            }
        });
    }
}
