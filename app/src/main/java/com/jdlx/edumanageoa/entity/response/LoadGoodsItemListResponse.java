package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.GoodsCategory;

import java.util.List;

/**
 * 加载商品项目列表的响应
 */
public class LoadGoodsItemListResponse extends BaseResponse {
    // 商品项目分类列表（分类中包含商品项目列表）
    private List<GoodsCategory> data;

    public List<GoodsCategory> getData() {
        return data;
    }

    public void setData(List<GoodsCategory> data) {
        this.data = data;
    }
}
