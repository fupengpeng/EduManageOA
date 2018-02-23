package com.jdlx.edumanageoa.fragment.view.shop;

/**
 * 门店
 */
public interface IShopView {
    /**
     * 设置门店ID
     *
     * @param shopId 门店ID
     */
    void setShopId(String shopId);

    /**
     * 当加载当前门店及个人信息成功
     */
    void onLoadUserShopInfoSuccess();

    /**
     * 当加载当前门店及个人信息失败
     */
    void onLoadUserShopInfoFail(Exception e);
}
