package com.jdlx.edumanageoa.entity.response;


import com.jdlx.edumanageoa.entity.ShopAssistantCategory;

import java.util.List;

/**
 * 加载门店店员列表的响应
 */
public class LoadShopAssistantListResponse extends BaseResponse{
    // 门店店员列表
    private List<ShopAssistantCategory> data;

    public List<ShopAssistantCategory> getData() {
        return data;
    }

    public void setData(List<ShopAssistantCategory> data) {
        this.data = data;
    }
}
