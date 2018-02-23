package com.jdlx.edumanageoa.entity;

import java.io.Serializable;

/**
 * 商品项目
 */
public class GoodsItem implements Serializable {
    // 商品ID
    private String goodsid;
    // 商品名称
    private String goodsname;
    // 编号
    private String hotkey;
    // 售价
    private String saleprice;
    // 缩略图
    private String imageurl;
    // 优惠折扣
    private String discount;
    // 折扣价
    private String discountprice;
    // 商品数量
    private int num;
    // 操作状态
    private String acstate;
    // 操作人id
    private String acuid;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getHotkey() {
        return hotkey;
    }

    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(String discountprice) {
        this.discountprice = discountprice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAcstate() {
        return acstate;
    }

    public void setAcstate(String acstate) {
        this.acstate = acstate;
    }

    public String getAcuid() {
        return acuid;
    }

    public void setAcuid(String acuid) {
        this.acuid = acuid;
    }
}
