package com.jdlx.edumanageoa.presenter.interf.shop;

/**
 * 登录界面主导器
 */
public interface IShopViewPresenter {
    /**
     * 加载当前门店及个人信息
     *
     * @param shopId 门店ID
     */
    void loadUserShopInfo(String shopId);

    /**
     * 加载当前门店的统计数据
     *
     * @param shopId 门店ID
     */
    void loadOrderCount(String shopId);
}
