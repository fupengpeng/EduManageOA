package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.ShopOrgan;

import java.util.List;

/**
 * 加载门店属性配置的响应
 */
public class LoadShopOrganResponse extends BaseResponse{
    // 门店属性配置列表
    private List<ShopOrgan> data;

    public List<ShopOrgan> getData() {
        return data;
    }

    public void setData(List<ShopOrgan> data) {
        this.data = data;
    }
}
