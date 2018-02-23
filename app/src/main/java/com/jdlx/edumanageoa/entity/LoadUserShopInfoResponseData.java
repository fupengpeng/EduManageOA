package com.jdlx.edumanageoa.entity;

/**
 * 加载当前门店及个人信息的响应数据
 */
public class LoadUserShopInfoResponseData {
    // 工作者信息
    private Worker user;
    // 店铺信息
    private Shop shop;

    public Worker getUser() {
        return user;
    }

    public void setUser(Worker user) {
        this.user = user;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
