package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * 商品项目分类
 */
public class GoodsCategory {
    // 商品项目分类ID
    private String goodscategoryid;
    // 商品项目分类名
    private String goodscategoryname;
    // 商品项目列表
    private List<GoodsItem> goodslist;

    public String getGoodscategoryid() {
        return goodscategoryid;
    }

    public void setGoodscategoryid(String goodscategoryid) {
        this.goodscategoryid = goodscategoryid;
    }

    public String getGoodscategoryname() {
        return goodscategoryname;
    }

    public void setGoodscategoryname(String goodscategoryname) {
        this.goodscategoryname = goodscategoryname;
    }

    public List<GoodsItem> getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(List<GoodsItem> goodslist) {
        this.goodslist = goodslist;
    }
}
