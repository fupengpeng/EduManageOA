package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.ShopAssistant;

import java.util.List;

/**
 * @description  获取服务项店员列表（含未设置可预约店员）
 * @author  fupengpeng
 * @date  2018/1/23 0023 18:39
 */
public class GetShopAssistantListResponse extends BaseResponse{
    // 门店店员列表
    private List<ShopAssistant> data;

    public List<ShopAssistant> getData() {
        return data;
    }

    public void setData(List<ShopAssistant> data) {
        this.data = data;
    }
}
