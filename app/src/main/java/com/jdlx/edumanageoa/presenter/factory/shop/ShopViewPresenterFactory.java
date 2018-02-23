package com.jdlx.edumanageoa.presenter.factory.shop;

import com.jdlx.edumanageoa.fragment.view.shop.IShopView;
import com.jdlx.edumanageoa.presenter.impl.shop.ShopViewPresenter;
import com.jdlx.edumanageoa.presenter.interf.shop.IShopViewPresenter;

/**
 * 门店界面主导器工厂
 */
public class ShopViewPresenterFactory {
    /**
     * 创建门店界面主导器对象
     *
     * @param shopView 门店界面
     * @return 门店界面主导器对象
     */
    public static IShopViewPresenter newInstance(IShopView shopView) {
        return new ShopViewPresenter(shopView);
    }

}
