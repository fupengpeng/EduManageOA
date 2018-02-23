package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.LoadUserShopInfoResponseData;

/**
 * 加载当前门店及个人信息的响应
 */
public class LoadUserShopInfoResponse extends BaseResponse{
    // 加载当前门店及个人信息的响应数据
    private LoadUserShopInfoResponseData data;

    public LoadUserShopInfoResponseData getData() {
        return data;
    }

    public void setData(LoadUserShopInfoResponseData data) {
        this.data = data;
    }
}
